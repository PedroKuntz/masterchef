package com.ello.masterchef.payment.model.mapper;

import com.ello.masterchef.payment.model.PaymentOrder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PaymentOrderRowMapper implements RowMapper<PaymentOrder> {

    @Override
    public PaymentOrder mapRow(ResultSet row, int i) throws SQLException {
        PaymentOrder paymentOrder = new PaymentOrder();
        paymentOrder.setPaymentOrderId(UUID.fromString(row.getString("payment_order_id")));
        paymentOrder.setPurchaseOrderId(UUID.fromString(row.getString("purchase_order_id")));
        paymentOrder.setPaymentOrderState(PaymentStateMapper.paymentOrderStateTo(row.getString("payment_order_state")));
        return paymentOrder;
    }

}
