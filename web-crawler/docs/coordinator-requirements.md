Justification:
There is a singleton coordinator in the system so that the system can scale as many workers as needed. The coordinator acts as a singleton which controls access to the database and ensures workers are being polite. The coordinator is also responsible for refreshing sites on expiration, allowing for continuous operation.


Requirements:
- an interface for approving/denying site requests by workers. For efficiency it should accept batches of sites at a time
- a method for pushing sites to a worker's queue on expiration
- an interface for recording updated information sourced from the workers to the database. This should be fairly minimal with the computation done by the worker.
- dynamic sourcing the seed sites from the csv's in seeds/ which are then pushed out to workers
- an interface for workers to "announce themselves" dynamically so the coordinator is aware of which nodes are currently operating and how they can be reached over the network.


problems:
- say that no sites in the db are expired and a new worker is added, how do we give it work? also true if a site somehow hits a full dead end. It would add more work for the coordinator and more network traffic but maybe every site discovered is added to a frontier queue and then allocated out to workers. that would work but the concern would be added worker downtime, I'll have to think about it.
