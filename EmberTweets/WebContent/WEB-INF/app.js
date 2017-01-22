/************************** * Application **************************/ 
/************************** * Models **************************/ 
/************************** * Views **************************/ 
App=Em.Application.create();
App.SearchTextField = Em.TextField.extend({ insertNewline: function(){ App.tweetsController.loadTweets(); } });

/************************** * Controllers **************************/ 