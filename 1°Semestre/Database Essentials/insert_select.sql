describe ssp;

INSERT INTO ssp 
	(SSPCodi, SSPNome)
VALUES 
	(01, 'SSP-RJ');
    
SELECT * FROM ssp;

INSERT INTO ssp 
VALUES 
	(02, 'SSP-RS');
    
INSERT INTO ssp 
VALUES 
	('SSP-MG', 3);
	-- eraddo precisa estar na ordem certa
    
INSERT INTO ssp 
(SSPNome, SSPCodi)
VALUES 
	('SSP-MG', 3);