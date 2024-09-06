# MAD
MAD Lab
This project is developed using Android Studio, an Integrated Development Environment (IDE) designed specifically for Android development. To get started with this project, first, you need to install Android Studio from the official website. Ensure that you have the latest version of the Android SDK and other necessary tools, such as an emulator, to run and test the project.

After installation, open Android Studio and clone this repository by navigating to File > New > Project from Version Control, and paste the URL of the repository. Once the project is loaded, you will need to sync the Gradle files. Android Studio will automatically prompt you to sync, or you can do it manually by selecting File > Sync Project with Gradle Files. This step ensures that all the project dependencies and configurations are correctly set up.

Next, you can either connect a physical Android device via USB or set up an emulator within Android Studio. For emulator setup, navigate to Tools > Device Manager, and create a new virtual device by following the on-screen instructions. Choose a device model and the system image (API level), then finish the setup. Once your emulator is ready or a physical device is connected, you can run the project by clicking the Run button or using the shortcut Shift + F10. Android Studio will build the project, install the app, and launch it on the connected device or emulator.

For debugging purposes, Android Studio provides a powerful toolset, including a logcat window to monitor system logs and a profiler to track memory, CPU, and network usage. You can use breakpoints to pause execution and inspect variables during runtime, which is useful for tracking down issues in your code. Additionally, Android Studio’s layout editor offers a drag-and-drop interface for designing UI components, allowing for real-time previews of the layout on various screen sizes and orientations.

The project structure follows the standard Android architecture, separating code into different packages for activities, fragments, adapters, and other components. All dependencies are managed via Gradle, and you can customize or add new libraries by editing the build.gradle files in the project. To make changes to the app’s UI, navigate to the res/layout folder where XML layout files are stored. Java or Kotlin code for handling app logic can be found under the src/main/java directory.

By using Android Studio’s built-in version control tools, you can easily track changes, commit code, and push updates to remote repositories such as GitHub. You can access these features by clicking on VCS > Git in the toolbar, allowing seamless integration with Git for version management.

