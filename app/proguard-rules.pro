##---------------Begin: proguard configuration common for all Android apps ----------
-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontskipnonpubliclibraryclassmembers
-dontpreverify
-verbose
#apk 包内所有 class 的内部结构
#-dump class_files.txt
#未混淆的类和成员
-printseeds seeds.txt
#列出从 apk 中删除的代码
-printusage unused.txt
#混淆前后的映射
-printmapping mapping.txt
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

-allowaccessmodification
-keepattributes *Annotation*
-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable

-keepattributes Exceptions,InnerClasses,Signature,Deprecated,EnclosingMethod
-repackageclasses ''

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.app.IntentService
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService
-keep public class * extends android.support.v4.app.Fragment
-dontnote com.android.vending.licensing.ILicensingService

# Explicitly preserve all serialization members. The Serializable interface
# is only a marker interface, so it wouldn't save them.
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# Preserve all native method names and the names of their classes.
-keepclasseswithmembers class * {
    native <methods>;
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

# Preserve static fields of inner classes of R classes that might be accessed
# through introspection.
-keepclassmembers class **.R$* {
  public static <fields>;
}

# Preserve the special static methods that are required in all enumeration classes.
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

#-keepattributes InnerClasses
#-keepattributes Exceptions

-keep public class * {
    public protected *;
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}
##---------------End: proguard configuration common for all Android apps ----------

##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { *; }

##---------------End: proguard configuration for Gson  ----------

# keep 使用 webview 的类的所有的内部类
-keepclassmembers  class  com.veidy.activity.WebViewActivity$*{ *; }
# webview + js
-keepattributes *JavascriptInterface*
# keep 使用 webview 的类
-keepclassmembers class  com.veidy.activity.WebViewActivity {
   public *;
}

#gson
#-libraryjars libs/gson-2.2.2.jar
# Gson specific classes
-keep class sun.misc.Unsafe { *; }
# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { *; }

-keepclassmembers class * {
    public void *ButtonClicked(android.view.View);
}

#保持 Serializable 不被混淆
-keepnames class * implements java.io.Serializable
#保持 Parcelable 不被混淆
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}
#保持自定义控件类不被混淆
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}
#保持自定义控件类不被混淆
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
#保持自定义控件类不被混淆
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

#-keepattributes Exceptions,InnerClasses,...


-keep class com.baidu.**{*; }
-keep class org.apache.**{*; }
-keep class android.support.**{*; }
-keep class org.apache.http.**{*; }
-keep class org.apache.log4j.**{*; }
-keep class com.nineoldandroids.**{*; }
-keep class com.nostra13.universalimageloader.**{*; }
-keep class com.google.zxing.**{*; }
-keep class android.**{*; }
-keep class com.google.gson.**{*; }
-keep class com.lidroid.xutils.**{*; }
-keep class org.appspot.apprtc.**{*; }
-keep class * extends java.lang.annotation.Annotation { *; }
#-keep class @Table(name="xxx")，@Id(column="xxx")，@Column(column="xxx"),@Foreign(column="xxx",foreign="xxx")
-keep class com.juan.media.**{*;}

-keep public class com.roobo.pudding.model.** {
    *;
}
-keep public class com.roobo.pudding.model.data.** {
    *;
}
-keep public class com.roobo.pudding.model.push.** {
    *;
}
-keep public class com.roobo.pudding.configwifi.data.** {
    *;
}
-keep public class com.roobo.pudding.configwifi.entity.** {
    *;
}
-keep public class com.roobo.pudding.statistics.UploadStatisticsFileReq {
    *;
}
-keep public class com.roobo.pudding.diagnosis.UploadDiagnosisFileReq {
    *;
}
-keep public class com.roobo.pudding.home.entity.** {
    *;
}
-keep public class com.roobo.pudding.statistics.modle.** {
    *;
}
-keep public class com.roobo.pudding.update.entity.** {
    *;
}
-keep public class com.roobo.pudding.dynamics.entity.** {
    *;
}
-keep public class com.roobo.pudding.gallery.entity.** {
    *;
}

#keep掉videolib工程中libjingle_peerconnection_java.jar的类
-keep class org.webrtc.** {
    *;
}

#keep掉videoapi工程中model类，避免网络请求失败
-keep class com.juan.bean.** {
    *;
}
-keep class com.juan.net.** {
    *;
}
-keep class com.juan.media.** {
    *;
}

#keep掉vitamio
-keep class io.vov.vitamio.** {
    *;
}

#keep掉微信分享sdk
-keep class com.tencent.mm.sdk.** {
   *;
}

#忽略警告
-ignorewarning


#忽略警告
-dontwarn android.support.**
-dontwarn android.**
-dontwarn org.apache.http.**
-dontwarn org.apache.log4j.**
-dontwarn com.nineoldandroids.**
-dontwarn com.nostra13.universalimageloader.**
-dontwarn com.google.zxing.**
-dontwarn com.google.gson.**
-dontwarn com.lidroid.xutils.**
-dontwarn org.appspot.apprtc.**
-dontwarn com.baidu.**
-dontwarn com.juan.bean.**
-dontwarn de.mindpipe.android.logging.log4j.**

#--------videoservice start
-keep public class com.roobo.video.internal.model.ModelBase {
    public *;
}

-keep public class * extends com.roobo.video.internal.model.ModelBase {
    public *;
}

-keep public class com.roobo.video.internal.model.BodyBase {
    public *;
}

-keep public class * extends com.roobo.video.internal.model.BodyBase {
    public *;
}

-keep class com.roobo.live.player.**{
    *;
}

-keep class org.webrtc.** {*; }

-keep public class * extends android.content.BroadcastReceiver

-keep public class com.roobo.video.media.**{*;}

-keep public class * extends com.roobo.video.internal.live.model.** {
    *;
}

-keep public class com.roobo.video.util.**{*;}

#--------videoservice end

#sky--------------------------------------------------------------------------------------------------------
    -keepattributes Exceptions,InnerClasses,Signature,Deprecated,SourceFile,LineNumberTable,*Annotation*,EnclosingMethod
    -keep class jc.sky.** { *; }

    # Some methods are only called from tests, so make sure the shrinker keeps them.
    -keep class android.support.v4.widget.DrawerLayout { *; }
    -keep class android.support.test.espresso.IdlingResource { *; }
    -keep class com.google.common.base.Preconditions { *; }

    # Proguard rules that are applied to your test apk/code.
    -ignorewarnings

    -keepattributes *Annotation*

    -keepclasseswithmembers class * {
           <init> ();
    }

    #butterknife 8.1

    # Retain generated class which implement ViewBinder.
    -keep public class * implements butterknife.internal.ViewBinder { public <init>(); }

    # Prevent obfuscation of types which use ButterKnife annotations since the simple name
    # is used to reflectively look up the generated ViewBinder.
    -keep class butterknife.*
    -keepclasseswithmembernames class * { @butterknife.* <methods>; }
    -keepclasseswithmembernames class * { @butterknife.* <fields>; }

    #nineoldandroids
    -dontwarn com.nineoldandroids.**
    -keep class com.nineoldandroids.** { *;}

    #glide
    -keep public class * implements com.bumptech.glide.module.GlideModule
    -keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
      **[] $VALUES;
      public *;
    }

    #eventbus3.0
    -keepclassmembers class ** {
        @org.greenrobot.eventbus.Subscribe <methods>;
    }
    -keep enum org.greenrobot.eventbus.ThreadMode { *; }

    # Only required if you use AsyncExecutor
    -keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
        <init>(java.lang.Throwable);
    }

    #okhttp3
    -keep class com.squareup.okhttp3.** {*;}

    #commons-io-1.3.2.jar
    -keep public class org.apache.commons.** {*;}

    #retrofit2
    -dontnote retrofit2.Platform
    -dontnote retrofit2.Platform$IOS$MainThreadExecutor
    -dontwarn retrofit2.Platform$Java8
    -keepattributes Signature
    -keepattributes Exceptions