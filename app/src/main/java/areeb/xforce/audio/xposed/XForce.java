package areeb.xforce.audio.xposed;

import android.media.AudioManager;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class XForce implements IXposedHookLoadPackage {

    private static final String HOOK_PACKAGE = "android", HOOK_CLASS = "android.media.AudioManager";
    private static final String HOOK_METHOD = "requestAudioFocus";

    @Override
    public void handleLoadPackage(LoadPackageParam loadPackageParam) throws Throwable {
        if (!loadPackageParam.packageName.equals(HOOK_PACKAGE))
            return;

        XposedBridge.log("Entered Android\nTrying to hook method");
        findAndHookMethod(HOOK_CLASS, loadPackageParam.classLoader, HOOK_METHOD,
                AudioManager.OnAudioFocusChangeListener.class, int.class, int.class,
                XC_MethodReplacement.returnConstant(AudioManager.AUDIOFOCUS_REQUEST_GRANTED));
        XposedBridge.log("Bomb has been planted!");
    }
}
