class User {
    String username; //@ of account
    String fullname; //display name
    int followers; //followers count

    //constructor
    User(String username, String fullname, int followers) {
        this.username = username;
        this.fullname = fullname;
        this.followers = followers;
    }

    /* 
       This method is expected to return a String which includes
       the full name (display name) of the Twitter account, and
       the user name of the account.
       NOTE: There should be a space and an @ sign before the
       username.
    */
    String toText() {
        return this.fullname + " @" + this.username;
    }
}

class Tweet {
    String tweet; //text of tweet
    User author;
    int likes; //how many likes a tweet has
    String ID; //unique ID for a tweet
    //added because i'm not sure if there's another way to get the info for toLink()
    String tweetURL; //the URL link of a tweet

    //constructor
    Tweet(String tweet, User author, int likes, String ID, String tweetURL) {
        this.tweet = tweet;
        this.author = author;
        this.likes = likes;
        this.ID = ID;
        this.tweetURL = tweetURL;
    }

    /* 
       This method is expected to compare two tweets' texts and
       determine which one has the most characters. If 'this' 
       tweet is longer than 'other' tweet, it should return true; 
       if not, it should return false.
    */
    boolean longerThan(Tweet other) {
        if(this.tweet.length() > other.tweet.length()) {
            return true;
        }
        return false;
    }

    /* 
       This method is expected to compare two tweets' likes and
       determine which one has the most likes. If 'this' tweet
       has more likes than 'other' tweet, it should return true;
       if not, it should return false.
    */
    boolean moreLikes(Tweet other) {
        if(this.likes > other.likes) {
            return true;
        }
        return false;
    }

    /*
       This method is expected to return all the user information.
       This includes their full name and user name of the account
       coming from the other toText() method in the User class,
       as well as the text of the tweet and likes that the tweet got.
       NOTE: There are spaces and colons separating most of this
       information, AND the word 'Likes' is added (with a space
       beofre) after the likes that the tweet got.
    */
    String toText() {
        return this.author.fullname + " @" + this.author.username + " : " + this.tweet + " : " + this.likes + " Likes";
    }

    /*
       This method is expected to return the URL link of a tweet.
    */
    String toLink() {
        return this.tweetURL;
    }
}

class ExampleTweets {
    //3 User objects
    User user1 = new User("cassidoo", "Cassidy", 171657);
    User user2 = new User("kprather88", "Kimberly Prather, Ph.D.", 40557);
    User user3 = new User("acmucsd", "ACM @ UCSD", 38);

    //calling method 1: toText() from class User: examples
    String userInfo1 = this.user1.toText();
    String userInfo2 = this.user2.toText();
    String userInfo3 = this.user3.toText();
    
    //getting each text of tweet for reference
    String text1 = "Power went out for #jamstackconf (and me) but the show must go on";
    String text2 = "It's October 3rd.";
    String text3 = "/vaccinate/";
    String text4 = "How's everyone doing?";

    //getting likes of each tweet for reference
    int likes1 = 732;
    int likes2 = 450;
    int likes3 = 76;
    int likes4 = 4;

    //getting each tweet ID for reference
    String ID1 = "1445792483087056902";
    String ID2 = "1444787585621057539";
    String ID3 = "1446504858974965765";
    String ID4 = "1389471842063245314";

    //getting each tweet URL for reference
    String tweet1URL = "https://twitter.com/cassidoo/status/1445792483087056902";
    String tweet2URL = "https://twitter.com/cassidoo/status/1444787585621057539";
    String tweet3URL = "https://twitter.com/kprather88/status/1446504858974965765";
    String tweet4URL = "https://twitter.com/acmucsd/status/1389471842063245314";
    
    //4 Tweet objects
    //Reminder that tweet1 and tweet2 are both from user1
    /*
    Were there any parts of the Tweet that you couldn’t represent with
    the class design we chose?
    I had no issues, except finding a way to incorporate a string representation
    for the URLs of the tweets for the toLink() method. In order to do this, I
    had to add an extra data called String tweetURL.
    */
    //https://twitter.com/cassidoo/status/1445792483087056902 
    Tweet tweet1 = new Tweet(text1, user1, likes1, ID1, tweet1URL);
    //https://twitter.com/cassidoo/status/1444787585621057539
    Tweet tweet2 = new Tweet(text2, user1, likes2, ID2, tweet2URL);
    //https://twitter.com/kprather88/status/1446504858974965765
    Tweet tweet3 = new Tweet(text3, user2, likes3, ID3, tweet3URL);
    //https://twitter.com/acmucsd/status/1389471842063245314
    Tweet tweet4 = new Tweet(text4, user3, likes4, ID4, tweet4URL);

    //calling method 2: longerthan() from class Tweet: examples
    boolean compareLength1 = this.tweet1.longerThan(this.tweet2); //expect true
    boolean compareLength2 = this.tweet3.longerThan(this.tweet4); //expect false
    boolean compareLength3 = this.tweet2.longerThan(this.tweet3); //expect true
    boolean compareLength4 = this.tweet4.longerThan(this.tweet1); //expect false

    //calling method 3: moreLikes() from class Tweet: examples
    boolean compareLikes1 = this.tweet1.moreLikes(this.tweet2); //expect true
    boolean compareLikes2 = this.tweet3.moreLikes(this.tweet4); //expect true
    boolean compareLikes3 = this.tweet2.moreLikes(this.tweet3); //expect true
    boolean compareLikes4 = this.tweet4.moreLikes(this.tweet1); //expect false

    //calling method 4: toText() from class Tweet: examples
    /*
       Expect: "Cassidy @cassidoo : Power went out for #jamstackconf (and me) 
       but the show must go on : 732 Likes"
    */
    String allInfo1 = this.tweet1.toText();
    /*
       Expect: "Cassidy @cassidoo : It's October 3rd. : 450 Likes"
    */
    String allInfo2 = this.tweet2.toText();
    /*
       Expect: "Kimberly Prather, Ph.D. @kprather88 : /vaccinate/ : 76 Likes"
    */
    String allInfo3 = this.tweet3.toText();
    /*
       Expect: "ACM @ UCSD @acmucsd : How's everyone doing? : 4 Likes"
    */
    String allInfo4 = this.tweet4.toText();

    //calling method 5: toLink() from class Tweet: examples
    /*
       Expect: "https://twitter.com/cassidoo/status/1445792483087056902"
    */
    String URL1 = this.tweet1.toLink();
    /*
       Expect: "https://twitter.com/cassidoo/status/1444787585621057539"
    */
    String URL2 = this.tweet2.toLink();
    /*
       Expect: "https://twitter.com/kprather88/status/1446504858974965765"
    */
    String URL3 = this.tweet3.toLink();
    /*
       Expect: "https://twitter.com/acmucsd/status/1389471842063245314"
    */
    String URL4 = this.tweet4.toLink();
}