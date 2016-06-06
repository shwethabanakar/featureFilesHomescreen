Story
As a user I should be able to control my overall Status update visibility settings extensively 
from settings page
Acceptance Criteria
1. Settings -> Privacy -> Status Updates opens an entire page dedicated to status updates
2. The page will have one row that points to a list of exceptions:
i) Tapping on this option would take me to a list of all the friends marked as exceptions with
 the ability to add/remove people
3. Changes made in exception list should be aligned and reflected in profile view of individual 
contacts also.


Scenario: Basic view.
Given : User has friends.
When : User goes to Settings > account > SU
Then: User should be taken to a exception screen.

Scenario: Default settings for SU settings.
Given : User A has few friends.
When: User A goes to settings > Account > SU > exception list.
Then: None of the friends should be checked.

Scenario: Search in SU and LAst seen Exception list.
Given : User has friends.
When: User goes to Settings > account > SU
And: Enters few characters in the exception screen.
Then: The list of contacts or contact matching that search should be listed.

Scenario: Multi select in SU and LAst seen exception list.
Given : User has friends.
When: User goes to Settings > account > SU
And: Enters few characters in the exception screen.
And: The list of contacts matching the search is listed.
Then: User should be able to select more than one contact from the search list.


Scenario: Last seen is selected as none and setting reflected on profile page 
( for every contact it should be no)
Given: User has friends.
When: User goes Settings > account > Last seen.
And: Selects None .
And: User opens the profile page of a person.
And: Taps on the privacy settings.
Then: The last seen should be disabled for that friend.


Scenario: Exception list before adding a contact.
Given : User has friends.
And: No privacy settings has done till now.
When : User goes to Settings > account > SU
And: User is taken to exception list.
Then: No contact is checked in the exception list.

Scenario: Exception list after adding a contact.
Given : User has friends.
When : User goes to Settings > account > SU
And: User adds few contacts to exception list.
And: User goes back to chat screen.
And: Goes to privacy settings to add few more contacts 
Then : SU exception list should have names and checked boxes beside it.

Scenario: Select contact and check back and forth.
Given : User has friends.
And:User goes to Settings > account >  SU 
And: User adds user B in the exception list.
When: User A goes to User B's profile.
And: Views privacy settings.
Then: The SU for user B should be Off (disabled).

			
Scenario: Add a contact to exception list in No n/w.
Given : User A has User B and USer C as friends.
And: User goes to settings > Account > Status Updates.
When: Device has no n/w or device is in APM.
And: User adds few  friends to exception list.
Then: Friends should get added to the exception list.

Scenario: Last seen and SU disabled reflection on profile screen.
Given : User A has friends.
And : User A goes to Settings > account > SU > Exception Screen.
When: UserA adds User B in the list.
And: User A Goes to User B's profile.
Then: The privacy for SU should be disabled or toggle OFF.

Scenario: Check functionality after this.
Given : User A has friends.
And : User A goes to Settings > account > SU > Exception Screen.
When: UserA adds User B in the list.
And: User A continues to chat with User B.
And: User B posts few pics.
Then: User A should not be able to see User B's last seen as well as status update messages.

Scenario: Settings page > Last seen  for a new user.
Given : User A has hike installed.
When: User A goes to settings > Account > SU
Then: UserA should not see any friend added there.

Scenarios : Settings page for SU for a new user.
Given : User A has hike installed.
When: User A goes to settings > Account > Last seen.
Then: UserA should have it selected as friends.


Scenario: Blocked contact name in Exception list.
Given : User A has hike installed.
And: User has blocked User B .
When: User A goes to Settings > account > Privacy > SU > Exception list
And: User searches for User B's name.
Then: The exception search list should not contain USer B's name who has been blocked.


Scenario: Names listed in Exception list should consists of only friends.
Given : User A has hike installed.
And: User A and User B are not friends.
When: User A goes to Settings > account > Privacy > SU > Exception list
And: User searches for User B's name.
Then: User B's name will not be listed in the search list .

Scenario: Hidden contact name in Exception list when locked.
Given: User A and User B are friends.
And: User B is a hidden contact/friend on User A's device.
And: Hidden mode is locked.
When: User A goes to Settings > account > Privacy > SU > Exception list.
And: User searches for User B's name.
Then: User B's name should not be listed.

			
Scenario: Hidden contact name in Exception list when unlocked.
Given: User A and User B are friends.
And: User B is a hidden contact/friend on User A's device.
And: Hidden mode is unlocked.
When: User A goes to Settings > account > Privacy > SU > Exception list.
And: User searches for User B's name.
Then: User B's name should be listed.

Scenario: User A added User B as friend but User B has not accepted.
Given : User A has added User B as friend.
When: User A goes to Settings > account > Privacy > SU > Exception list.
And: Searches for User B's name.
Then: User B's name should be listed.


			



