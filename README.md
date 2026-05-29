

## Outline:

implementation decisions:
- Java web crawler
- Java api to interact with frontend
- Vue frontend
- PostgreSQL database

MVP:
- polite web crawler
    - csv seed loading
    - parallelizable
- web search on indexed websites
- front end page to interact with the backend
- simple boolean search option
- bare minimum 1000 sites

Extensions:
- 100,000+ sites
- fancier ranking options
- Specialty search. Idea is to have csv files with links for core page seeding (games, coding, etc)
- some way to backup the database storing sites for persistence, I don't want to keep re-running the crawler

