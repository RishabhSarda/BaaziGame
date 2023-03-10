select
  *
from
  (
    SELECT
      *
    FROM
      student
    order by
      marks
  )
order by
  id
limit
  3;
