INSERT INTO tb_user (username, password, role) VALUES
('admin', '$2a$10$SENHA_JA_CRIPTOGRAFADA_AQUI', 0),
('joao', '$2a$10$SENHA_JA_CRIPTOGRAFADA_AQUI', 1),
('maria', '$2a$10$SENHA_JA_CRIPTOGRAFADA_AQUI', 1);

INSERT INTO tb_task (title, description, completed, user_id) VALUES
('Estudar Spring Security', 'Revisar JWT e filtros', false, 2),
('Fazer prova de JPA', 'Repassar relacionamentos', true, 2),
('Comprar mantimentos', 'Lista de compras da semana', false, 3);