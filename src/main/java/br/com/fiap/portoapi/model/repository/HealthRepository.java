package br.com.fiap.portoapi.model.repository;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.portoapi.model.Health;
import jakarta.validation.Valid;

public class HealthRepository extends Repository {

	public static List<Health> findAll() {

		String sql = "SELECT * FROM T_VP_PACIENTE";

		PreparedStatement ps = null;

		ResultSet rs = null;

		List<Health> dados = new ArrayList<>();

		try {
			ps = getConnection().prepareStatement(sql);

			rs = ps.executeQuery();

			if (rs.isBeforeFirst()) {
				while (rs.next()) {

					Health dado = new Health();

					dado.setId(rs.getLong("ID_PAC"));
					dado.setNmPaciente(rs.getString("NM_PAC"));
					dado.setDataNascimentoPaciente(rs.getDate("DT_NASC_PAC").toLocalDate());
					dado.setCpfPaciente(rs.getLong("CPF_PAC"));
					dado.setRgPaciente(rs.getLong("RG_PAC"));
					dado.setEnderecoPaciente(rs.getString("END_PAC"));
					dado.setCepPaciente(rs.getLong("CEP_PAC"));
					dado.setEmailPaciente(rs.getString("EMAIL_PAC"));
					dado.setSenhaPaciente(rs.getLong("SENHA_PAC"));
					dado.setAlturaPaciente(rs.getFloat("ALTURA_PAC"));
					dado.setPesoPaciente(rs.getFloat("PESO_PAC"));

					dados.add(dado);
				}
			} else {
				System.out.println("Nao foram encontrados registros");
			}

		} catch (SQLException e) {
			System.out.println("Nao foi possivel listar: " + e.getMessage());
		}

		return dados;

	}
	
	public static Health save(Health health) {
		String sql = "INSERT INTO T_VP_PACIENTE (" +
			    "id_pac, nm_pac, dt_nasc_pac, cpf_pac, rg_pac, end_pac, cep_pac, email_pac, senha_pac, altura_pac, peso_pac" +
			    ") " +
			    "VALUES (SQ_PAC.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    CallableStatement cs = null;

	    try {
	        cs = getConnection().prepareCall(sql);

	        cs.setString(1, health.getNmPaciente());
	        cs.setDate(2, Date.valueOf(health.getDataNascimentoPaciente()));
	        cs.setLong(3, health.getCpfPaciente());
	        cs.setLong(4, health.getRgPaciente());
	        cs.setString(5, health.getEnderecoPaciente());
	        cs.setLong(6, health.getCepPaciente());
	        cs.setString(7, health.getEmailPaciente());
	        cs.setLong(8, health.getSenhaPaciente());
	        cs.setDouble(9, health.getAlturaPaciente());
	        cs.setDouble(10, health.getPesoPaciente());
	        
	        cs.execute();

	        
	        return health;

	    } catch (SQLException e) {
	        System.out.println("Erro ao salvar: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        if (cs != null)
	            try {
	                cs.close();
	            } catch (SQLException e) {
	                System.out.println("Não foi possível fechar: " + e.getMessage());
	            }
	    }

	    return null;
	}


	public static boolean delete(Long healthId) {
		
		Health health = null;
		String sql = "DELETE FROM T_VP_PACIENTE where ID_PAC = ?";
		PreparedStatement ps = null;
		
		health = findById(healthId);
		
		if(health == null) {
			return false;
		}

		try {
			ps = getConnection().prepareStatement(sql);
			
			ps.setLong(1, healthId);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erro para deletar no banco de dados: " + e.getMessage());
		} finally {
			if(ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					System.out.println("Erro ao fechas o PS: " + e.getMessage());
				}
		}
		
		return false;
	}

	
	public static Health findById(Long id) {
		String sql = "SELECT * FROM T_VP_PACIENTE where ID_PAC = ?";
		
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		try {
			ps = getConnection().prepareStatement(sql);
			
			ps.setLong(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.isBeforeFirst()) {
				Health dado = new Health();
				while(rs.next()) {
					dado.setId(rs.getLong("ID_PAC"));
					dado.setNmPaciente(rs.getString("NM_PAC"));
					dado.setDataNascimentoPaciente(rs.getDate("DT_NASC_PAC").toLocalDate());
					dado.setCpfPaciente(rs.getLong("CPF_PAC"));
					dado.setRgPaciente(rs.getLong("RG_PAC"));
					dado.setEnderecoPaciente(rs.getString("END_PAC"));
					dado.setCepPaciente(rs.getLong("CEP_PAC"));
					dado.setEmailPaciente(rs.getString("EMAIL_PAC"));
					dado.setSenhaPaciente(rs.getLong("SENHA_PAC"));
					dado.setAlturaPaciente(rs.getFloat("ALTURA_PAC"));
					dado.setPesoPaciente(rs.getFloat("PESO_PAC"));
				}
				
				return dado;
			}
			
		} catch (SQLException e) {
			System.out.println("Erro para consultar o item no banco de dados: " + e.getMessage());
		}finally {
			if(ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					System.out.println("Erro ao fechas o PS: " + e.getMessage());
				}
			
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("Erro ao fechas o RS: " + e.getMessage());
				}

		}
		
		return null;
		
	}

	public static Health update(@Valid Health health) {
		
		
	 
		String sql = "begin UPDATE T_VP_PACIENTE set NM_PAC=?, DT_NASC_PAC=?, CPF_PAC=?, RG_PAC=?, END_PAC=?, CEP_PAC=?, EMAIL_PAC=?, SENHA_PAC=? , ALTURA_PAC=?, PESO_PAC=? where ID_PAC = ? return ID_PAC into ?; end;";

		CallableStatement cs = null;
		
		
		try {
			cs = getConnection().prepareCall(sql);

			cs.setString(1, health.getNmPaciente() );
			cs.setDate(2, Date.valueOf(health.getDataNascimentoPaciente()));
			cs.setLong(3, health.getCpfPaciente() );
			cs.setLong(4, health.getRgPaciente() );
			cs.setString(5, health.getEnderecoPaciente() );
			cs.setLong(6, health.getCepPaciente() );
			cs.setString(7, health.getEmailPaciente() );
			cs.setLong(8, health.getSenhaPaciente() );
			cs.setDouble(9, health.getAlturaPaciente() );
			cs.setDouble(10, health.getPesoPaciente() );
			cs.setLong(11, health.getId() );
			cs.registerOutParameter(12, java.sql.Types.BIGINT);
			cs.executeUpdate();
			
			
			return health;
			
		} catch (SQLException e) {
			System.out.println("Nao foi possivel atualizar no banco de dados: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if(cs!=null)
				try {
					cs.close();
				} catch (SQLException e) {
					System.out.println("Nao foi possivel fechar: " + e.getMessage());
				}
		}
		
		return null;
	}
	

}
