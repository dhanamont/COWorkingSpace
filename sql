SELECT r.Order_Date, r.Start_Time, r.End_Time, r.Order_Status, t.Table_ID,
            o.Room_Name, y.Type_Name, s.Space_Name
            From `User` u
            JOIN Ordering r USING (User_ID)
            JOIN `Table` t USING (Table_ID)
            JOIN Room o USING (Room_ID)
            JOIN Type_Space y USING (Type_ID)
            JOIN `Space` s USING (Space_ID)
            WHERE u.User_ID = ? ;
            <sql:param value="${User_ID}"/>
