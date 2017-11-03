# POTTER PALS

## Group 5

### Designing an app to allow users to login/sign-up and interact with various features of the application.

app >> src = Dir; contains the source code

app >> src >> main >> res >> layout = Dir; XML files contained here 

app >> src >> main >> java/edu/fsu/cs/cen4020/potterpals = Dir; contains java files implementing all the UI 

build.gradle = file; Andorid Studio generated during run time 

README.md = this file

#### *Java Files*

MainActivity.java - Homepage & contains UI to navigate to login or sign-up page, quiz feature, invite friends feature, or read book 
summaries feature. 

LoginUser.java - UI for user to enter email and password. If matches the one on the database, then permit access.

RegisterUser.java - UI to allow user to create a profile. Update the database with the user provided information.

BookList.java - List view for user to select book title he/she wishes to read the summary of.

BookSummary.java - Displays the book summary corresponding to the title choice made by the user. 

HouseQuiz.java - Allows the user to take a quiz and update the resulting "house" on the database. 

Invite.java - User can "invite" friends to join the Potter pals community. 

MyContentProvider.java - Database managed through a content provider. Overwritten functions to search, update, and insert records into 
database.

##### *XML files contain the layouts and widgets for the UI implemented via java*
