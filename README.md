# QuizApp
Project3 - UDACITY - Android Basics

<b>Features:</b>

<ul>
<li>The app has 3 activity: MainActivity, QuizActivity, ResultActivity.</li>
<li>The app has 3 different scores to define the type of fan, the score increases according to the given answer.</li>
<li>The ResultAtivity changes according to the highest score obtained.</li>
<li>The QuizActivity keeps the data even if you switch from a portrait to landscape and the other way around.</li>
<li>The QuizActivity checks that there is an answer to each question.</li>
<li>The app gives the possibility to send an email with the result of the quiz and the link to the app.(the link is not active because the app is not on the playstore)</li>
<li>The app is localized in 3 languages: English (default), Italian and Spanish.</li>
</ul>

<b>Screenshot:</b>

<img src="https://github.com/Slypher1/QuizApp/blob/master/screenshot/PJ3-1.JPG" width="160" height="320"><img src="https://github.com/Slypher1/QuizApp/blob/master/screenshot/PJ3-2.JPG" width="160" height="320"><img src="https://github.com/Slypher1/QuizApp/blob/master/screenshot/PJ3-3.JPG" width="160" height="320"><img src="https://github.com/Slypher1/QuizApp/blob/master/screenshot/PJ3-4.JPG" width="160" height="320"><img src="https://github.com/Slypher1/QuizApp/blob/master/screenshot/PJ3-5.JPG" width="160" height="320"><img src="https://github.com/Slypher1/QuizApp/blob/master/screenshot/PJ3-6.JPG" width="160" height="320"><img src="https://github.com/Slypher1/QuizApp/blob/master/screenshot/PJ3-6b.JPG" width="160" height="320"><img src="https://github.com/Slypher1/QuizApp/blob/master/screenshot/PJ3-7.JPG" width="160" height="320"><img src="https://github.com/Slypher1/QuizApp/blob/master/screenshot/PJ3-8.JPG" width="160" height="320"><img src="https://github.com/Slypher1/QuizApp/blob/master/screenshot/PJ3-9.JPG" width="160" height="320"><img src="https://github.com/Slypher1/QuizApp/blob/master/screenshot/PJ3-R1.JPG" width="160" height="320"><img src="https://github.com/Slypher1/QuizApp/blob/master/screenshot/PJ3-R2.JPG" width="160" height="320"><img src="https://github.com/Slypher1/QuizApp/blob/master/screenshot/PJ3-R3.JPG" width="160" height="320"><img src="https://github.com/Slypher1/QuizApp/blob/master/screenshot/mail.png" width="180" height="320">

<b>Problems encountered and solutions:</b>

<ol>
<li>When I tried to use my smartphone as a debugging device to try to send the e-mail, I noticed a different behavior from the emulator. In my smartphone the app is blocked and gave me an error like: java.lang.OutOfMemoryError. Caused by the images too big, I solved by following this post:

https://stackoverflow.com/questions/32244851/androidjava-lang-outofmemoryerror-failed-to-allocate-a-23970828-byte-allocatio</li>


<li>I wanted to implement a reset button to go back to the beginning of the quiz, but using 3 activity I thought if there was a method to reset the whole app, as if it had just been launched. I found these two posts:

https://stackoverflow.com/questions/2470870/force-application-to-restart-on-first-activity
https://stackoverflow.com/questions/34065087/restart-app-programmatically</li>
</ol>
