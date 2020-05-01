package kr.ac.jejunu.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStatementStrategy implements StatementStrategy {
    @Override
    public PreparedStatement makeStatemanet(Object object, Connection connection) throws SQLException {
        int id = (int)object;
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("delete from userinfo where id =?");

        preparedStatement.setInt(1, id);
        return preparedStatement;
    }
}
