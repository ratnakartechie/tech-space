CREATE DEFINER=`test`@`localhost` PROCEDURE `split_col_into_rows`(tablename varchar(20),
id_column varchar(20),value_column varchar(20), delim CHAR(1))
BEGIN

DECLARE id INT DEFAULT 0;
DECLARE val VARCHAR(255);
DECLARE occurrences INT DEFAULT 0;

DECLARE i INT DEFAULT 0;
DECLARE split_value VARCHAR(255);

DECLARE done INT DEFAULT 0;
 DECLARE cur CURSOR FOR SELECT temp_table.id,temp_table.val FROM 
        temp_table WHERE temp_table.val IS NOT NULL AND temp_table.val != '';
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
    

drop temporary table if exists temp_table;
SET @expr = CONCAT('CREATE TEMPORARY TABLE temp_table (id INT NOT NULL, val VARCHAR(255)) ENGINE=Memory SELECT ',
        id_column,' id, ', value_column,' value FROM ',tablename);

/*
Prepare Statement from above Expr and Execute, Deallocate
*/
PREPARE stmt from @expr;
execute stmt;
deallocate prepare stmt;

/*Drop Temp Table if exists and create new now
*/
drop temporary table if exists temp_sometbl;
create temporary table temp_sometbl(id INT NOT NULL, val VARCHAR(255) NOT NULL)
Engine=MEMORY;

/*
Get all rows into temp table via cursor
*/
OPEN cur;
read_loop: LOOP /*start loop fetch cursor into table*/
FETCH cur into id,val;
if done then
leave read_loop;
/* Get the occurences */
SET occurrences = (SELECT CHAR_LENGTH(val) -
                           CHAR_LENGTH(REPLACE(val, delim, '')) + 1);                          

end if;
/*
Check for occurences of delimiter in string
*/

set i=1;
while i<=occurences DO
set split_value=(SELECT TRIM(SUBSTRING_INDEX(
              SUBSTRING_INDEX(val, delim, i), delim, -1)));
          INSERT INTO tmp_sometbl VALUES (id, split_value);
set i=i+1;
END while;
end loop;

select * from temp_sometbl;
close cur;

drop temporary table temp_table;
        
END