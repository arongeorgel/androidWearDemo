Android Wear Demo
===============

A short demo for android wear


    Launch Android SDK Manager.
        From Eclipse, select Window > Android SDK Manager.
        From Android Studio, select Tools > Android > SDK Manager.
    Below Tools, verify that you have Android SDK Tools revision 22.6 or higher.

    If your version of Android SDK Tools is lower than 22.6, you must update:
        Select Android SDK Tools.
        Click Install package.
        Accept the license and click Install.
        When the installation completes, restart Android SDK Manager.
    Below Android 4.4.2, select Android Wear ARM EABI v7a System Image.

    Note: Android Wear is designed to support multiple processor architectures.
    Below Extras, ensure that you have the latest version of the Android Support Library. If an update is available, select Android Support Library. If you're using Android Studio, also select Android Support Repository.
    Click Install packages.
    Accept the license and click Install.

2. Set Up the Android Wear Emulator

    Launch the Android Virtual Device Manager.
        From Eclipse, select Window > Android Virtual Device Manager.
        From Android Studio, select Tools > Android > AVD Manager.
    Click New.
    For the AVD Name, enter "AndroidWearSquare" or "AndroidWearRound", depending on whether you want to create an emulator with a square or round display.
    For the Device, select Android Wear Square or Android Wear Round.
    For the Target, select Android 4.4.2 - API Level 19 (or higher).
    For the CPU/ABI, select Android Wear ARM (armeabi-v7a).

    Note: Android Wear is designed to support multiple processor architectures.
    For the Skin, select AndroidWearSquare or AndroidWearRound.
    Leave all other options set to their defaults and click OK.

    Although real Android wearables do not provide a keyboard as an input method, you should keep Hardware keyboard present selected so you can provide text input on screens where users will instead provide voice input.
    In the list of AVDs, select the one you just created and click Start. In the following window, click Launch.

The Android Wear emulator now starts. To begin testing your app's notifications, you must now pair the emulator to your development device that has the Android Wear Preview app installed.

Tip: To improve the emulator startup time, edit your AVD and enable Snapshot under Emulator Options. When you start the emulator, select Save to snapshot then click Launch. Once the emulator is running, close it to save a snapshot of the system. Start the AVD again, but select Launch from snapshot and deselect Save to snapshot.

Caution: Do not install apps on the Android Wear emulator. The system does not support traditional Android apps and the result of running such apps is unpredictable.
3. Set Up the Android Wear Preview App

To view your app's notifications on the Android Wear emulator, you must have the Android Wear Preview app installed on your Android device (a phone or tablet).

To receive the Android Wear Preview app, you must sign up for the Developer Preview using the same Gmail or Google account you use with Google Play Store.

Note: The Android Wear Preview app is compatible with Android 4.3 and higher and is not available for the Android emulator.

After you've signed up for the Developer Preview, you'll receive a confirmation email that includes a link to opt-in to the Android Wear Preview app beta program. Once you opt-in, it may take up to 24 hours for the app to become available in Google Play Store.

After you install the Android Wear Preview app, you can set up your device to communicate with the Android Wear emulator:

    Open the Android Wear Preview app. You should see a notice that the app is currently not enabled as a notification listener. Tap the message to open the system settings, then select Android Wear Preview to grant it notification access.
    Connect your device to your development machine over USB. Be sure that no other Android devices are connected to the machine.
    Ensure that the Android Wear emulator (created in the previous section) is running. The emulator should show the time and an icon that indicates no device is connected.
    Open a command line terminal, navigate to your Android SDK's platform-tools/ directory, then execute:

    adb -d forward tcp:5601 tcp:5601

    Note: You must execute this command each time you connect your device over USB.
    Return to the Android Wear Preview app. It should now indicate that it is connected to the emulator. The Android Wear emulator should now show the 'g' orb icon, indicating that is is connected to your device. 

Now, notifications from your device also appear in the Android Wear emulator.
4. Add the Support Library to Your Project

The Android Wear preview support library includes several APIs that allow you to optimize your app's notifications for the Android Wear user experience.

To receive the preview support library, you must sign up for the Developer Preview. The confirmation email you receive after you sign up includes a link to download a ZIP file, which contains the preview support library and some sample apps.

After you download and unzip the package, add the preview support library sto your Android project:

If you're using Eclipse:

    In your Android app project, create a libs/ directory in your project root (the same location as the AndroidManifest.xml file).
    Copy the v4 support library JAR file from your Android SDK directory (e.g., <sdk>/extras/android/support/v4/android-support-v4.jar) into your project libs/ directory.
    Also save the wearable-preview-support.jar file in the libs/ directory.
    Right click each JAR file and select Build Path > Add to Build Path.

If you're using Android Studio:

    In your Android app project, create a libs/ directory in your project root (the same location as the AndroidManifest.xml file).
    Save the wearable-preview-support.jar file in the libs/ directory.
    Open the build.gradle file in your app module.
    Add a dependency rule for both the v4 support library and the Android Wear preview support library:

    dependencies {
        compile "com.android.support:support-v4:18.0.+"
        compile files('../libs/wearable-preview-support.jar')
    }

    Click Sync Project with Gradle Files in the toolbar
