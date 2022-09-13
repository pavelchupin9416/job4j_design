--Хранимая процедура. Удаление по id/
create or replace procedure delete_data_by_id(u_id integer)
language 'plpgsql'
as $$
    BEGIN
       DELETE FROM products
       WHERE id = u_id;
    END;
$$;

--Функция. Удаление товара равное количеству.
create or replace function delete_data_by_count(i_count integer)
returns void
language 'plpgsql'
as
$$
    begin
         DELETE FROM products
         WHERE count = i_count;
    end;
$$;