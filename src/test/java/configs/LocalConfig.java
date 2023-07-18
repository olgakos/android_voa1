package configs;
import org.aeonbits.owner.Config;


@Config.Sources({
        "classpath:params/android_emulator.properties"
})
public interface LocalConfig extends Config {

    @Key("localURL")
    String localUrl();

    @Key("platformName")
    String platformName();

    @Key("deviceName")
    String deviceName();

    @Key("platformVersion")
    String platformVersion();

    @Key("appLocalURL")
    String appLocalURL();

    @Key("appPath")
    String appPath();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

}