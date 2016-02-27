# itad230.lwtech
###Programming for Mobile Devices Class
Because this is a class, and the class is in progress, this file will not be the usual README file.

####ASSIGNMENT 3: IMPLICIT INTENTS
The application includes 3 intents: a timer, an alarm, and a camera.  The buttons on the main activity start the appropriately-named activity by determining what services are available on the device for that function and then sending them an intent.

I tested the app on a live device after testing as much as possible on an emulator.  The emulator I chose simulated a camera and returns null to the calling activity instead of a file.

This was the first assignment from this class for which I used GitHub.  There is a GitHub shell and another GitHub download that made uploading the project work fairly well. I would appreciate having the time to learn all the ins and outs of using GitHub.

####ASSIGNMENT 4: LOCATION
This assignment was to convert code from an activity to a service.  The service that was chosen was the location service, provided to the Android platform by Google Play services.  There are 4 buttons: one starts the location service, another stops it, a third displays all the location information, and the fourth clears the location information from the screen. This was far too ambitious for the time that I could allot to the project, but I will also put this aside for further study.

As usual, I feel that I put more time into platform support than I did on programming.  That will change after I build one or two stable test platforms. I loaded Android Studio SDK on a flash drive for portability between platforms, and included several SDK images.  I found some usb drivers that worked with the computer and an external device. I also deleted (too many) temp files from the computer, which made compiles take longer than usual while Android determined what caches to rebuild. 

As for the program itself, this was an exercise in simultaneous research and development.  At first I put all the code in one activity, although I knew the program would be calling it from elsewhere. The New File options were not available because they disappear while Android is updating its indices. I compiled the draft program successfully, which validated the research and let me know the code was at least halfway good.

After Android Studio New Service file was created, I put the service code into a file that was separate from the main activity. I removed the file handling code and changed all the compile options to be compatible with the device, which is SDK 19. I also turned on its location services. 

I can run a program more often with an external device; the emulators either didn't load or were very slow. One or two runs per hour is insufficient for thorough testing.
