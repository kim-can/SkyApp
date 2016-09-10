#!/usr/bin/python
# coding=utf-8
import sys
import zipfile
import shutil
import os
# 定义 日志类
class Log(object):
    RED     = '\033[31m'
    GREEN   = '\033[32m'
    YELLOW  = '\033[33m'
    MAGENTA = '\033[35m'
    RESET   = '\033[0m'
    
    @staticmethod
    def skyPrint(s, color = None):
        if color and sys.stdout.isatty() and sys.platform != 'win32':
            print(color + s + Log.RESET)
        else:
            print(s)
    
    @staticmethod     
    def d(s):
        Log.skyPrint(s, Log.MAGENTA)
        
     
    @staticmethod   
    def i(s):
        Log.skyPrint(s, Log.GREEN)
        
    @staticmethod
    def w(s):
        Log.skyPrint(s, Log.YELLOW)
        
    @staticmethod
    def e(s):
        Log.skyPrint(s, Log.RED)

# 空文件 便于写入此空文件到apk包中作为channel文件
src_empty_file = './channel/skychannelname.txt'
# 创建一个空文件（不存在则创建）
f = open(src_empty_file, 'w') 
f.close()

apkpath = './app/build/outputs/apk/'
# 获取指定目录中所有的apk源包
src_apks = []
def gci(filepath):
#遍历filepath下所有文件，包括子目录
  files = os.listdir(filepath)
  for file in files:
    fi_d = os.path.join(filepath,file)            
    if os.path.isfile(fi_d):
       filename = os.path.basename(file)
       if 'unaligned.apk' in filename:
          Log.d("exclude unaligned.apk:%s\n" %filename)  
       else:  
          extension = os.path.splitext(file)[1][1:] 
          if extension in 'apk':
             src_apks.append(fi_d)
		  

#获取apkpath下的apk文件
gci(apkpath)

Log.d("source apks:%s\n" %src_apks)

# 获取渠道列表
channel_file = './channel/channellist.txt'
f = open(channel_file)
lines = f.readlines()
f.close()

Log.d("channel list:%s\n" %lines)

for src_apk in src_apks:
    # file name (with extension)
    src_apk_file_name = os.path.basename(src_apk)
    # 分割文件名与后缀
    temp_list = os.path.splitext(src_apk_file_name)
    # name without extension
    src_apk_name = temp_list[0]
    # 后缀名，包含.   例如: ".apk "
    src_apk_extension = temp_list[1]
    
    # 创建生成目录,与文件名相关
    output_dir = apkpath + 'channel_' + src_apk_name + '/'

    Log.d("output_dir:%s\n" %output_dir)

    # 目录不存在则创建
    if not os.path.exists(output_dir):
        os.mkdir(output_dir)

    # 遍历渠道号并创建对应渠道号的apk文件
    for line in lines:
        # 获取当前渠道号，因为从渠道文件中获得带有\n,所有strip一下
        target_channel = line.strip()
        # 拼接对应渠道号的apk
        target_apk = output_dir + src_apk_name + "-" + target_channel + src_apk_extension

        Log.d("target channel apk:%s\n" %target_apk)

        # 拷贝建立新apk
        shutil.copy(src_apk,  target_apk)
        # zip获取新建立的apk文件
        zipped = zipfile.ZipFile(target_apk, 'a', zipfile.ZIP_DEFLATED)
        # 初始化渠道信息
        empty_channel_file = "META-INF/skychannelname-{channel}".format(channel = target_channel)
        # 写入渠道信息
        zipped.write(src_empty_file, empty_channel_file)
        # 关闭zip流
        zipped.close()
