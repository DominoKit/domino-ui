package org.dominokit.domino.ui.loaders;

public class LoaderFactory {

    public static IsLoader make(LoaderEffect type){
        switch (type){

            case BOUNCE:
                return BounceLoader.create();
            case ROTATE_PLANE:
                return RotatePlaneLoader.create();
            case STRETCH:
                return StretchLoader.create();
            case ORBIT:
                return OrbitLoader.create();
            case ROUND_BOUNCE:
                return RoundBounceLoader.create();
            case WIN8:
                return Win8Loader.create();
            case WIN8_LINEAR:
                return Win8LinearLoader.create();
            case IOS:
                return IosLoader.create();
            case FACEBOOK:
                return FacebookLoader.create();
            case ROTATION:
                return RotationLoader.create();
            case TIMER:
                return TimerLoader.create();
            default:
                return NoneLoader.create();
        }
    }

}
