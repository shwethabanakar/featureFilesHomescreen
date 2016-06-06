@friendsTest
Feature:To Test new friends functionality.
AC : 1. User should see a prominent add friend button on the chat thread when user tries to initiate a chat
2. User does not have access to any of the chatting options (sticker palette, attachment pallet, etc.) before sending the friend request
3. User is able to see the DP (we need to honour the settings of the other person here)
4. User should not be able to see the last seen of the contact
5. Once user taps on it, they should be able to send the message and have access to all additional chatting options
6. Last seen is still not visible, unless the friend request is accepted (show something like, 'friend" request pending' as a place holder to avoid -ve perception)"


Scenario:Friends Chat Functionality 
Given:User has hike app installed and have contacts saved and not friends.
When:User Opens the compose message for these contacts.
Then: "Add friend" option should be seen in place of text field.

Scenario : 

