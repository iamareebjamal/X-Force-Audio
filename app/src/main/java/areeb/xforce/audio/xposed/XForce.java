package areeb.xforce.audio.xposed;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class XForce implements IXposedHookLoadPackage {

    public static final String HOOK_CLASS = "android";

    @Override
    public void handleLoadPackage(LoadPackageParam loadPackageParam) throws Throwable {
        if(!loadPackageParam.packageName.equals(HOOK_CLASS))
            return;

        XposedBridge.log("Entered Android");
    }
}
