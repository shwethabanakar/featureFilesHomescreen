Acceptance Criteria
1. Land on Conversation Screen regardless of notification type if the app was dismissed earlier
2. Open the last opened screen if the app was not dismissed earlier


Scenario: User kills hike app and launches.
Given: User is on Screen < Screen Foreground >
When: User Kills the app.
And: User get notification.
And: User launches the app with badge count.
Then: User is taken to Chat tab in < orientation> if orientation is supported.

Example:
 | Screen Foreground	| Orientation	|
 | Chat Tab				| Landscape		|
 | Me Tab 				| Portrait	
 | Settings 			|
 | Friends tab			|
 | Hidden mode chats	|
 | Chat thread			|
 | GC					|
 | Profile picture		|
 | Add friends			|
 | Added me screen		|
 | Service				|
 | Activity Page		|
 | Compose page			|
 | Friends profile		|
 
 Scenario : user backgrounds the app and launches before its suspended.
 Given user is on screen < Screen Foreground >
 When user backgrounds hike app.
 And User get < Notification for > < Notification from > 
 And User taps on the hike app before it gets suspended.
 Then the user should land on < Screen Foreground > 
 And < Orientation > if screen orientation is supported.
 
 Example:
 |  Screen Foreground   | Notification for    	  	|    Notification from     	| Orientation	|
 | Chat tab				| Message/Nudges/		  	|							| Landscape		|
						| Stickers/ Files/ Audio  	| 							| Portrait		|
						| Location / Contact      	|    1-1 Message 			| 
 | GC Chat thread 		| Message/Nudges/			|
						| Stickers/ Files/ Audio  	| 
						| Location / Contact  	  	|   1-1 Message 			| 
 | Chat tab 				| Like Notification 	  	|   Friends 				| 
 | Chat tab				| Status/Photo Post	      	|    Friends				| 
 | GC Chat thread 		| Like Notification 		|    Friends 				| 
 | GC Chat thread		| Status/Photo Post			|   Friends					| 
 | 1-1 Message thread	|  Message/Nudges/			|
						| Stickers/ Files/ Audio  	| 
						| Location / Contact  		|  Group Chat 				| 
 | 1-1 Message thread 	| Like Notification 		|    Friends 				| 
 | 1-1 Message thread 	| Status/Photo Post			|   Friends					| 
 | 1-1 Message thread 	| Message/Nudges/			|
						| Stickers/ Files/ Audio  	| 
						| Location / Contact  		|  Hidden Contact 			| 
 | 1-1 Message thread 	| Like notification 		| Hidden contact 			| 
 | 1-1 Message thread 	| Photo/status post			| Hidden contact 			| 
 | Me tab 				|Message/Nudges/			|
						| Stickers/ Files/ Audio  	| 
						| Location / Contact  		|  1-1 Chat 				| 
 | Me Tab 				| Like notification			| Friends 					| 
 | Me Tab				| Photo/ Status post		| Friends					|  
 | Me Tab > Add friends	|
 | Me Tab > Added me 	|  Message/Nudges/			|
						| Stickers/ Files/ Audio  	| 
						| Location / Contact  		|  1-1 Chat / GC 			| 
 | Me Tab > Add friends	|
 | Me Tab > Added me 	| Like 						| friends 					| 
 | Me Tab > Add friends	|
 | Me Tab > Added me 	| Photo /Status post		| Friends					| 	
 | Chat Tab				| Message 					| 1-1 chat					|
 | Me Tab 				| Nudge						| GC						|
 | Settings 			| Like						| Friends					|
 | Friends tab			| Status post				| Friends					|
 | Chat thread			| None						| None						|
 | GC					| None						| None						|
 | Profile picture		| None						| None						|
 | Add friends			| None						| None						|
 | Added me screen		| None						| None						|
 | Service				| None						| None						|
 | Activity Page		| None						| None						|
 | Compose page			| None						| None						|
 | Friends profile		|  None						| None						|
 
 
 Scenario : user backgrounds the app when hidden mode is unlocked and launches .
 Given user is on screen < Screen Foreground >
 And: Settings > Account > "hide chat on app exit " is ON.
 When user backgrounds hike app.
 And User get < Notification for > < Notification from > 
 And User taps on the hike app before it gets suspended.
 Then the user should land on < Screen Foreground > 
 And Orientation should be < Orientation > if screen orientation is supported.
 
  Example:
  |  Screen Foreground   | Notification for    	  	|    Notification from     	| Orientation	|
 | Chat tab				| Message/Nudges/		  	|							| Landscape		|
						| Stickers/ Files/ Audio  	| 							| Portrait		|
						| Location / Contact      	|    1-1 Message 			| 
 | GC Chat thread 		| Message/Nudges/			|
						| Stickers/ Files/ Audio  	| 
						| Location / Contact  	  	|   1-1 Message 			| 
 | Chat tab 			| Like Notification 	 	| Friends 					| 
 | Chat tab				| Status/Photo Post	      	|    Friends				| 
 | GC Chat thread 		| Like Notification 		|    Friends 				| 
 | GC Chat thread		| Status/Photo Post			|   Friends					| 
 | 1-1 Message thread	|  Message/Nudges/			|
						| Stickers/ Files/ Audio  	| 
						| Location / Contact  		|  Group Chat 				| 
 | 1-1 Message thread 	| Like Notification 		|    Friends 				| 
 | 1-1 Message thread 	| Status/Photo Post			|   Friends					| 
 | 1-1 Message thread 	| Message/Nudges/			|
						| Stickers/ Files/ Audio  	| 
						| Location / Contact  		|  Hidden Contact 			| 
 | 1-1 Message thread 	| Like notification 		| Hidden contact 			| 
 | 1-1 Message thread 	| Photo/status post			| Hidden contact 			| 
 | Me tab 				|Message/Nudges/			|
						| Stickers/ Files/ Audio  	| 
						| Location / Contact  		|  1-1 Chat 				| 
 | Me Tab 				| Like notification			| Friends 					| 
 | Me Tab				| Photo/ Status post		| Friends					|  
 | Me Tab > Add friends	|
 | Me Tab > Added me 	|  Message/Nudges/			|
						| Stickers/ Files/ Audio  	| 
						| Location / Contact  		|  1-1 Chat / GC 			| 
 | Me Tab > Add friends	|
 | Me Tab > Added me 	| Like 						| friends 					| 
 | Me Tab > Add friends	|
 | Me Tab > Added me 	| Photo /Status post		| Friends					| 	
 | Chat Tab				| Message 					| 1-1 chat					|
 | Me Tab 				| Nudge						| GC						|
 | Settings 			| Like						| Friends					|
 | Friends tab			| Status post				| Friends					|
 | Chat thread			| None						| None						|
 | GC					| Photo /Status post		| Friends					| 	
 | Profile picture		| None						| None						|
 | Add friends			| Photo /Status post		| Friends					| 	
 | Added me screen		| None						| None						|
 | Service				| Status post				| Friends					|
 | Activity Page		| None						| None						|
 | Compose page			| Message 					| 1-1 chat					|
 | Friends profile		|  None						| None						|
 
 
 

  
 