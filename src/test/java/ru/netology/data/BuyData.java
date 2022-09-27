package ru.netology.data;

import lombok.Data;

@Data
public class BuyData {
    String id;
    String amount;
    String created;
    String status;
    String transaction_id;
}
