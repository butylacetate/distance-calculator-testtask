create table distance
(
    id           bigint auto_increment primary key,
    distance     double null,
    from_city_id bigint null,
    to_city_id   bigint null,
    constraint FK6crccwhu960vuuekq6tbly324
        foreign key (from_city_id) references city (id),
    constraint FKtepm1h3hntyi7hsmk4n1r86pd
        foreign key (to_city_id) references city (id)
);