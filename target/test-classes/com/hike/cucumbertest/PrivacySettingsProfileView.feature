HS-950
Story
As a user I should be able to quickly choose whether a contact is able to see my status updates or not
Acceptance Criteria
1. I should have the option to show/hide SU to this friend in his profile view
2. If A has sent friend request to B, then A will have the option accessible, but B
 still won't have access to this option.
3. If A has disabled SU for B, then A will also not receive SUs from B
4. Changes made in profile view should be in aligned and reflected in exception list also
5. If a user 'A' decides to turn off SU for a user 'B', then it will also remove the older 
status updates of 'A' from 'B's profile.


Scenario: User wants to view the privacy settings on User B's profile.
Given: UserA and User B are friends
When: User opens a friends User B's chat thread.
And: Opens the profile.
Then: User should see Manage privacy option with down arrow.

Scenario: Default privacy settings on UserB 's profile.
Given: UserA and User B are friends
When: User opens a friends User B's chat thread.
And: Opens the profile.
And: Tap on the down arrow.
Then:User should see options like "last seen" and " Status Updates" with ON Status.
And: The arrow pointing above.

Scenario: Close the drop down using the up arrow .
Given: UserA is on User B's profile.
And : User A Taps on Down arrow next to Privacy settings.
When: Taps on the Up arrow.
Then: The two options gets hidden.

Scenario : Toggle the privacy switch ON and OFF.
Given: User A is on User B's profile.
When: User A taps on Privacy settings.
And: User A Toggles < Switch State > the < Privacy type  >
Then: The switch state is < Switch State >

Example:
| SWicth State		|  Privacy Type	|	
| ON 				|  SU	 		|
| Off 				|  SU			|
| ON				| Last seen		|
| Off 				| Last seen		|

Scenario : Toggle the privacy switch ON and OFF.
Given: User A is on User B's profile.
When: User A taps on Privacy settings.
And: User A Toggles < Switch State > the < Privacy type  >
Then: The switch state is < Switch State >


Scenario: User A does not want User B to view his < Privacy type  >.
Given: User A is on User B's profile.
When: User A taps on Privacy settings.
And: User A Toggles OFF the < Privacy type  >
Then : User B should not be able to see User A  < Privacy type > Anymore.

Example:	
| Privacy  type			|
| Last seen				|
| Status Updates		|

Scenario: Access User B's profile after turning off the Status updates for User B.
Given: User A is on User B's profile.
When: User A taps on Privacy settings.
And: User A Toggles OFF the Status updates.
Then :User A will not be able to view latest posts from User B 's profile too.

Scenario: User B's timeline posts when USer A has turned off SU with User B.
Given: User A and User B are friends
And: User A is on User B's profile.
And: User A taps on Privacy settings.
And: User A Toggles OFF the Status updates.
And: User B posts few SU < SU Type >
When: User A goes to friends Tab > timeline 
Then: User A will not see any SU < SU type > from user B 

Example:
| SU Type 		|
| Photo post	|
| Status only	|

Scenario: User B's timeline posts when USer A has turned off SU with User B.
Given: User A and User B are friends.
And: User A is on User B's profile.
And: User A taps on Privacy settings.
And: User A Toggles OFF the Status updates.
And: User B posts few SU < SU Type >
When: User A's App status is  < App Status > 
Then: User A will not get any notifications for User B's posts.

Example:
| SU Type 		| App Status	|
| Photo post	| Killed		|
| Status only	| Background	|

Scenario : User B's views timeline after the privacy settings for SU has been done from User A.
Given: User A and User B are friends.
And: User A is on User B's profile.
And: User A taps on Privacy settings.
And: User A Toggles OFF the Status updates.
And: User A posts few SU < SU Type >
When: User B goes to friends Tab > timeline 
Then: User B will not see any SU < SU type > from user A.

 Example:
| SU Type 		|
| Photo post	|
| Status only	|

Scenario: User A's timeline posts when USer A has turned off SU with User B.
Given: User A and User B
And:User A is on User B's profile.
And: User A taps on Privacy settings.
And: User A Toggles OFF the Status updates.
And: User A posts few SU < SU Type >
When: User B's App status is  < App Status > 
Then: User B will not get any notifications for User A's posts.

Scenario: User A has added User B as friend but User B has not accepted.
Given: User A added User B as friend.
When: User A is on User B's profile.
Then: User A should have privacy settings option.

Given: User A added User B as friend.
When: User B is on User A's profile.
Then: User B should not see any privacy settings options.

Scenario : User A and User B are not friends.
Given: User A has not added User B as friend and vice versa.
When: User A is on User B's profile.
Then: User A should not see any option for privacy settings.

Scenario: User A's privacy settings for User B reflected in Hike> settings > ( Not yet given ).
Given : User A and User B are friends.
When: User A disables < Privacy type > from User B's profile screen.
And: Opens the settings page ( Not yet given ) < privacy type >
Then : Toggle for User B should be OFF .

Example: 
| Privacy  type			|
| Last seen				|
| Status Updates		|

Scenario: User A and User B both set privacy for each other and one enables it.
Given: User A and User B are friends.
ANd: User A disables status updates Privacy settings from profile page.
AND: User B Disables status updates  Privacy settings from profile page.
When: User A is on User B's profile page.
And: User A enables SU settings from privacy settings .
Then: Both User A and User B will still not get the SUs of one another.

Scenario: Status of toggle when Either of the friends disables the SU from privacy settings on profile page.
Given : User A and User B are friends.
And: User A disables SU from privacy settings on User B's profile page.
When: User B opens User A's profile.
And: Taps on Privacy settings.
Then: SU should be enabled.

Scenario :Status of privacy settings within hike settings.
Given: User A and User B are friends.
And: User has disabled SU from User B's profile page.
When: User A goes to settings > account > Status updates.
Then : User A will see User B's name with a tick mark on exception screen.


Scenario: SU Switch state on profile page when no network.
Given : User A and User B are friends.
And: User A is on Profile page of User B.
And: Device is in APM.
When: User A disables the SU from User B's profile screen.
Then: The toggle state will change. ( need to check but as of now since its a mqtt packet the state should retain).


Scenario: User A disables User B from viewing SU from settings page.
Given : User A and User B are friends.
When: User A goes to settings > account > privacy >
And: User A select SU option.
And: User A selects User B's name.
And: User A goes to profile page of User B.
Then: The SU for User B should be Off.
*/ More of Settings page Vs Profile page covered in HS-975.





 







 






