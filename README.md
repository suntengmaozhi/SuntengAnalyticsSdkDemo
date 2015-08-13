# Android 统计分析SDK帮助文档

### 1, 添加SDK JAR包到eclipse工程

> **重要：**这是强制性的。

将 SuntengAnalytics-sdk-android-x.x.x.jar 文件添加到项目的"libs"目录


### 2, 更新项目的 AndroidManifest.xml 文件
> **重要：**这是强制性的。
#### 添加权限：
``` xml
	<uses-permission android:name="android.permission.INTERNET"/>
	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
	<uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
	<uses-permission android:name="android.permission.READ_PHONE_STATE"/>
	<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
```

### 3, 初始化SDK
> **重要：**这是强制性的。

在项目的主activity的onCreate()中调用如下静态方法：
``` java
import com.sunteng.statservice.StatService;
	/**
	 * 初始化统计服务
	 * @param context 设备上下文
	 * @param appkey 应用唯一标志符,暂联系我司商务人员获取
	 * @param customorId 客户id，暂联系我司商务人员获取
	 * @param channel 安装渠道，填写对应的发行渠道，例如googleplay...
	 */
    public static void startStatService(Context context, String appkey, String customorId, String channel)
```

### 4, 基础页面统计
使用下面的方法统计activity的访问情况：
``` java
import com.sunteng.statservice.StatService;
	/**
	 * 标记一次页面访问的开始
	 * @param context 页面上下文
	 */
	public static void onResume(Context context)；

	/**
	 * 标记一次页面访问结束
	 * @param context 页面上下文
	 */
	public static void onPause(Context context)；
```

> **提示：**onResume和onPause需要成对使用才能正常统计activity，为了统计准确性，建议在每个activity中都调用以上接口，否则可能会导致sdk上报过多的启动次数

### 5, 特殊页面统计
使用下面的方法统计特殊页面：
``` java
import com.sunteng.statservice.StatService;
	/**
	 * 标记一次页面开始
	 * @param context 页面上下文
	 * @param pageName 页面的名称
	 */
    public static void trackBeginPage(Context context, String pageName)
	/**
	 * 标记一次页面的结束
	 * @param context 页面上下文
	 * @param pageName 页面的名称
	 */
    public static void trackEndPage(Context context, String pageName)
```


### 6, 自定义事件统计
使用下面的静态方法统计自定义事件：
``` java
import com.sunteng.statservice.StatService;
	/**
	 * 标记自定义事件
	 * @param context 上下文
	 * @param catelog 事件的分类
	 * @param action 事件的动作
	 * @param tag 事件的标签
	 * @param value 事件的价值
	 */
	public static void trackCustomEvent(Context context, String catelog, String action,String tag, int value)

```
### 7, 配置设置
##### 7.1Debug模式：
``` java
import com.sunteng.statservice.StatConfig;
	/**
	 * 设置debug模式
	 * @param bool true为开启，默认为false
	 */
	public static void setDebugEnable(boolean bool)
```
> **提示：**在debug模式下会输出SDK的log信息等,请在release版中设置为false。

##### 7.2设置数据上报策略：
考虑到wifi上报数据的代价比较小，为了更及时获得用户数据，SDK默认在WIFI网络下实时发送数据
``` java
import com.sunteng.statservice.StatConfig;
	/**
	 * 实时发送，app每产生一条消息都会发送到服务器。
	 */
	public static final int INSTANT = 1;
	/**
	 * 只在wifi状态下发送，非wifi情况缓存到本地。
	 */
	public static final int ONLY_WIFI = 2;
    /**
     * 只在启动时发送，本次产生的所有数据在下次启动时发送。
     */
    public static final int APP_LAUNCH = 3; 	
	/**
	 * 设置报告策略
	 * @param policy 请传入INSTANT或其他，默认为ONLY_WIFI
	 */
	public static void setReportPolicy(int policy)