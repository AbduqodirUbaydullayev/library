# library
Library project for OneVizion

<h3>Project Description</h3>
  The project includes a database of books, providing a comprehensive repository for book-related information. Additionally, it offers a set of APIs for interacting with the book database enabling users to perform various operations such as adding and retrieving books.

<h3>API info</h3>
  <p>(GET) /api/books - returning a list of all the books contained in the book table, sorted in reverse alphabetical order by the values of the book.title column</p> 
  <p>(POST) /api/books - adding a new book to the book table</p> 
  <p>(GET) /api/books/grouped-by-author - returning a list of all books grouped by book author (book.author)</p> 
  <p>(GET) /api/books/search-by-character - This endpoint accepts a character as a parameter and returns a list of 10 authors whose books' titles contain this character the most number of times</p>

<h3>Stack</h3>

- server port is running on 8080
- version of java 18
- version of Spring boot 3.2.5
- PostgreSQL was used for the database
  - by default credentials
    - `port = 5432`
    - `table name = library`
    - `user = root`
    - `passwrod = root`
- Liquibase was used for initializing and manipulating with database