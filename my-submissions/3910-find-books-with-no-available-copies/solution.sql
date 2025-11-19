SELECT 
    LB.book_id,
    LB.title,
    LB.author,
    LB.genre,
    LB.publication_year,
    COUNT(*) AS current_borrowers
FROM library_books LB 
JOIN borrowing_records BR 
      ON LB.book_id = BR.book_id
WHERE BR.return_date IS NULL
GROUP BY 
    LB.book_id,
    LB.title,
    LB.author,
    LB.genre,
    LB.publication_year,
    LB.total_copies
HAVING COUNT(*) = LB.total_copies
ORDER BY current_borrowers DESC, LB.title ASC;
