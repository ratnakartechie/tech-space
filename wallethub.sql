/*
Write a query to rank order the following table in MySQL by votes, display the rank as one of the
columns.
*/
select name, votes, @rank:=@rank + 1 as rank 
from test.votes, (select @rank := 0) r
order by votes desc

select initcap("United states Of aMErica") from dual;

/*
Create a table bugs, having fields id, open_date, close_date and severity.
On any given day a bug is open if open_date is less than or equal to current date
and close_date is greater than or equal to current date
Write an SQL Query that will show open bugs.
**/
select * from test.bugs bug where bug.open_date<=now() and bug.close_date>=now();

call split_col_into_rows('test.sometbl','ID', 'NAME','|');