SELECT BOOK.BOOK_ID, AUTHOR.AUTHOR_NAME, TO_CHAR(BOOK.PUBLISHED_DATE, 'YYYY-MM-DD') AS PUBLISHED_DATE
FROM BOOK
INNER JOIN AUTHOR ON BOOK.AUTHOR_ID = AUTHOR.AUTHOR_ID
WHERE BOOK.CATEGORY = '경제'
ORDER BY PUBLISHED_DATE ASC;

