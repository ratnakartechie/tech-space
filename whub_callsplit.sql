CREATE DEFINER=`test`@`localhost` PROCEDURE `split_row_into_columns`(tablename VARCHAR(20),
id_column varchar(20),value_column varchar(20), delim CHAR(1))
BEGIN
DECLARE id INT DEFAULT 0;
DECLARE value VARCHAR(255);
DECLARE occur INT DEFAULT 0;
DECLARE i INT DEFAULT 0;
DECLARE split_value VARCHAR(255);
DECLARE done INT DEFAULT 0;
DECLARE cur CURSOR FOR SELECT temp_tbl.id,temp_tbl.val
FROM temp_tbl where temp_tbl.val is NOT NULL and temp_tbl.val!='';


SET @expr = CONCAT('CREATE TEMPORARY TABLE tmp_tbl (id INT NOT NULL, 
val VARCHAR(255)) ENGINE=Memory SELECT ',
        id_column,' id, ', value_column,' val FROM ',tablename);
    PREPARE stmt FROM @expr;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
    
DROP TEMPORARY TABLE IF EXISTS tmp_table;
    CREATE TEMPORARY TABLE tmp_table(id INT NOT NULL, value VARCHAR(255) NOT NULL) ENGINE=Memory;

OPEN cur;
      read_loop: LOOP
        FETCH cur INTO id, value;
        IF done THEN
          LEAVE read_loop;
        END IF;

        SET occur = (SELECT CHAR_LENGTH(value) -
                           CHAR_LENGTH(REPLACE(value, delim, '')) + 1);
        SET i=1;
        WHILE i <= occur DO
          SET split_value = (SELECT TRIM(SUBSTRING_INDEX(
              SUBSTRING_INDEX(value, delim, i), delim, -1)));
          INSERT INTO tmp_table VALUES (id, split_value);
          SET i = i + 1;
        END WHILE;
      END LOOP;

      SELECT * FROM tmp_table;
    CLOSE cur;
    DROP TEMPORARY TABLE tmp_tbl;

END;