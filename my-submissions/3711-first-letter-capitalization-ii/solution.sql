WITH RECURSIVE words AS (
    -- Extract first word
    SELECT
        content_id,
        split_part(content_text, ' ', 1) AS word,
        substring(
            content_text
            FROM length(split_part(content_text, ' ', 1)) + 2
        ) AS remaining_text,
        1 AS token_index
    FROM user_content

    UNION ALL

    -- Extract next words recursively
    SELECT
        content_id,
        split_part(remaining_text, ' ', 1) AS word,
        substring(
            remaining_text
            FROM length(split_part(remaining_text, ' ', 1)) + 2
        ) AS remaining_text,
        token_index + 1
    FROM words
    WHERE remaining_text IS NOT NULL
      AND remaining_text <> ''
),
converted AS (
    SELECT
        content_id,
        string_agg(
            CASE
                -- hyphenated word logic
                WHEN position('-' in word) > 0 THEN
                    -- left part
                    upper(substring(word FROM 1 FOR 1)) ||
                    lower(substring(word FROM 2 FOR (position('-' in word) - 2))) ||
                    '-' ||
                    -- right part
                    upper(substring(split_part(word, '-', 2) FROM 1 FOR 1)) ||
                    lower(substring(split_part(word, '-', 2) FROM 2))
                ELSE
                    -- normal word capitalization
                    upper(substring(word FROM 1 FOR 1)) ||
                    lower(substring(word FROM 2))
            END,
            ' ' ORDER BY token_index
        ) AS converted_text
    FROM words
    GROUP BY content_id
)
SELECT
    uc.content_id,
    uc.content_text AS original_text,
    converted.converted_text
FROM user_content uc
JOIN converted USING (content_id)
ORDER BY uc.content_id;

