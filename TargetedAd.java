/*
 * Problem 2.3.1 Sell My Pet Food
 */
public class TargetedAd {

  public static void main(String[] args)
  {
    /*  
     * TODO:
      * PREPARATION WORK 
      * (1) Create a file called targetWords.txt. Populate this file with words on each line that
      *     you think would determine if a user is a dog or cat owner.
      * DONE
      * 
      * PROGRAMMING
      * (2) Create a new DataCollector object and set the data to "socialMediaPostsSmall.txt" and "targetWords.txt"
      *     Important: Use the socialMedialPostsSmall to create your algorithm. Using a small file will help you 
      *     generate your solution quicker and give you the ability to double check your work.
      * DONE
      * (3) Create a String variable to hold the names of all the user. (The first word of every post is 
      *     a person's username)
     * 
     * (4) Compare each user's post to each target word. If a user mentions a target word, add their username to 
     *     the String of users. Separate usernames with a space. 
     *         Hint: You can use loops to look through each word. 
     *         Hint2: You can use indexOf to check if a word is in a user post. 
     * (5) Once you have all the users, use your DataCollector's prepareAdvertisement method to prepare a file 
     *     with all users and the advertisement you will send them.
     *         Additional Info: The prepareAdvertisement creates a new file on your computer. Check the posts of
     *         some of the usernames to make sure your algorithm worked.
     * 
     * THE FINAL SOLUTION
     * (6) Your solution should work with the socialMedialPostsSmall.txt. Modify your DataCollector initialization
     *    so you use the socialMediaPosts.txt. You should now have a larger file of users to target.
     */


    /* your code here */
    

    DataCollector data = new DataCollector();

    data.setData("socialMediaPostsSmall.txt", "targetWords.txt");
    java.util.ArrayList<String> usernamesSet = new java.util.ArrayList<>();

    String post;
    while (!(post = data.getNextPost()).equals("NONE")) {
      String[] parts = post.split(" ");
      if (parts.length == 0) continue;
      String username = parts[0];

      String targetWord;
      while (!(targetWord = data.getNextTargetWord()).equals("NONE")) {
        if (post.toLowerCase().indexOf(targetWord.toLowerCase()) != -1) {
          usernamesSet.add(username);
        }
      }
    }

    StringBuilder usersBuilder = new StringBuilder();
    for (String u : usernamesSet) {
      if (usersBuilder.length() > 0) usersBuilder.append(' ');
      usersBuilder.append(u);
    }
    String users = usersBuilder.toString();

    data.prepareAdvertisement("adSmall.txt", users, "Check out our turtle food deal!");
    System.out.println("Wrote adSmall.txt for " + usernamesSet.size() + " users.");

    data = new DataCollector();
    data.setData("socialMediaPosts.txt", "targetWords.txt");
    usernamesSet = new java.util.ArrayList<>();

    while (!(post = data.getNextPost()).equals("NONE")) {
      String[] parts2 = post.split(" ");
      if (parts2.length == 0) continue;
      String username = parts2[0];

      String targetWord2;
      while (!(targetWord2 = data.getNextTargetWord()).equals("NONE")) {
        if (post.toLowerCase().indexOf(targetWord2.toLowerCase()) != -1) {
          usernamesSet.add(username);
        }
      }
    }

    usersBuilder.setLength(0);
    for (String u : usernamesSet) {
      if (usersBuilder.length() > 0) usersBuilder.append(' ');
      usersBuilder.append(u);
    }
    users = usersBuilder.toString();
    data.prepareAdvertisement("adFull.txt", users, "Check out our turtle food deal!");
    System.out.println("Wrote adFull.txt for " + usernamesSet.size() + " users.");
     
  }

}


