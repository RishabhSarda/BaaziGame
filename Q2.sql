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
  ) as s
order by
  id
limit
  3;
