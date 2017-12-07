# Text-to-speech
Android Text to Speech for all version above than 1.6 including marshmallow

Changing Language

You can change language to speak by using setLanguage() function. Lot of languages are supported like Canada, French, Chinese, Germany etc.,

textToSpeech.setLanguage(Locale.CHINESE); // Chinese language

Changing Pitch Rate

You can set speed pitch level by using setPitch() function. By default the value is 1.0 You can set lower values than 1.0 to decrease pitch level or greater values for increase pitch level.

textToSpeech.setPitch(0.6);

Changing Speed Rate

The speed rate can be set using setSpeechRate(). This also will take default of 1.0 value. You can double the speed rate by setting 2.0 or make half the speed level by setting 0.5

textToSpeech.setSpeechRate(2);


[![Watch the video]()](https://www.youtube.com/watch?v=9pvp7ku12v8)
