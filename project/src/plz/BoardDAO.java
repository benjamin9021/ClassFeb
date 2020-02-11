package plz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO {
	private DataSource dataFactory;
	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insert(BoardDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		String sql = "insert into board(num,id,title,content,reproot,repstep,repindent,notice) values(?,?,?,?,?,0,0,0)";
		try {
			con = dataFactory.getConnection();
			int num = createNum(con);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setInt(5, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, con);
		}
	}
	public int createNum(Connection con) {
		int num = 1;
		PreparedStatement pstmt = null;
		
		String sql = "select max(num) from board";
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1)+1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}
		return num;
	}
	
	public List<BoardDTO> list(){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		Connection con = null;
		PreparedStatement pstmt=null;
		String sql = "select num,title,id,to_char(writeday,'yyyy/mm/dd') writeday,"
				+ "readcnt,reproot,repstep,repindent,notice"
				+ " from board order by reproot desc,repstep asc";
		ResultSet rs = null;
		
		try {
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String title = rs.getString(2);
				String id = rs.getString(3);
				String writeday = rs.getString(4);
				int readcnt = rs.getInt(5);
				int repRoot = rs.getInt(6);
				int repStep = rs.getInt(7);
				int repIndent = rs.getInt(8);
				int notice = rs.getInt(9);
				
				list.add(new BoardDTO(num, id, title, null, writeday, readcnt, repRoot, repStep, repIndent,notice));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	public BoardDTO read(int num) {
		ResultSet rs = null;
		BoardDTO dto = null;
		Connection con = null;
		PreparedStatement pstmt=null;
		
		String sql = "select * from board where num=?";
		
		try {
			con = dataFactory.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				String id = rs.getString("id");
				
				dto = new BoardDTO(num, id, title, content, writeday, readcnt, 0, 0, 0,0);
			}
			
			increaseReadcnt(num,con);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		
		return dto;
	}
	private void increaseReadcnt(int num, Connection con) {
		PreparedStatement pstmt = null;
		String sql = "update board set readcnt = readcnt+1 where num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}
				
	}
	public void delete(int num) {
		Connection con = null;
		PreparedStatement pstmt=null;
		
		String sql = "delete from board where num = ?";
		
		try {
			con = dataFactory.getConnection();
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, con);
		}
				
				
		
	}
	public BoardDTO updateui(int num) {
		ResultSet rs = null;
		BoardDTO dto = null;
		Connection con = null;
		PreparedStatement pstmt=null;
		
		String sql = "select * from board where num=?";
		
		try {
			con = dataFactory.getConnection();
			pstmt=con.prepareCall(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				String id = rs.getString("id");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				int notice = rs.getInt(9);
				
				dto = new BoardDTO(num, id, title, content, writeday, readcnt, repRoot, repStep, repIndent,notice);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		
		return dto;
	}
	public void update(BoardDTO dto) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pstmt=null;
		
		String sql = "update board set title=?,content=? where num=?";
		
		try {
			con = dataFactory.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getNum());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, con);
		}
		
	}
	public BoardDTO replyui(int num) {
		BoardDTO dto = null;
		return dto;
	}
	public void reply(int orinum, String title, String content, String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board (num,title,id,content,repRoot,repStep,repIndent)"
					+" values(?,?,?,?,?,?,?)";
		boolean isOk = false;
		
		try {
			con = dataFactory.getConnection();
			con.setAutoCommit(false);
			BoardDTO dto = updateui(orinum);
			increaseRepStep(con,dto);
			
			int num = createNum(con);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			pstmt.setString(2, title);
			pstmt.setString(3, id);
			pstmt.setString(4, content);
			pstmt.setInt(5, dto.getRepRoot());
			pstmt.setInt(6, dto.getRepStep()+1);
			pstmt.setInt(7, dto.getRepIndent()+1);
			
			pstmt.executeUpdate();
			
			isOk = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(isOk) {
					con.commit();
				} else {
					con.rollback();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void increaseRepStep(Connection con, BoardDTO dto) {
		PreparedStatement pstmt = null;
		String sql = "update board set repStep = repStep +1 where repRoot = ? and repStep > ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getRepRoot());
			pstmt.setInt(2, dto.getRepStep());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}
	}
	public PageTO list(int curPage) {
		PageTO to = new PageTO(curPage);
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from (select rownum rnum,num,title,id, to_char(writeday, 'yyyy/mm/dd') writeday, readcnt, repRoot, repStep, repIndent from (select * from board order by repRoot desc, repStep asc)) where rnum between ? and ?";
		
		try {
			con = dataFactory.getConnection();
			
			to.setAmount(getAmount(con));
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, to.getStartNum());
			pstmt.setInt(2, to.getEndNum());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String id = rs.getString("id");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int repStep = rs.getInt("repStep");
				int repRoot = rs.getInt("repRoot");
				int repIndent = rs.getInt("repIndent");
				int notice = rs.getInt(9);
				
				BoardDTO dto = new BoardDTO(num, id, title, null, writeday, readcnt, repRoot, repStep, repIndent,notice);
				list.add(dto);
			}
			
			to.setList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return to;
	}
	
	private int getAmount(Connection con) {
		int amount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		String sql = "select count(num) from board";
		
	try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				amount = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, null);
		}
		
		
		return amount;
	}
	
	   public PageTO list(int curPage, String option, String searchtext) {
		      List<BoardDTO> list = new ArrayList<BoardDTO>();
		      PageTO to = new PageTO(curPage);
		      Connection con = null;
		      PreparedStatement pstmt = null;
		      ResultSet rs = null;
		      Boolean isOk = true;
		      

		      System.out.println(curPage+option+searchtext+"받아오는값입니다.");
		      if (isOk) {
		         Connection con2 = null;
		         PreparedStatement pstmt2 = null;
		         ResultSet rs2 = null;
		         String sql2 = "select count(num) num from board where "+option+" like ?";
		         try {
		            con2 = dataFactory.getConnection();
		            pstmt2 = con2.prepareStatement(sql2);
		            pstmt2.setString(1, "%"+searchtext+"%");
		            
		            rs2 = pstmt2.executeQuery();
		            
		            if (rs2.next()) {
		               to.setAmount(rs2.getInt("num"));
		               
		               isOk = false;
		            }
		         } catch (Exception e) {
		            e.printStackTrace();
		         } finally {
		            closeAll(rs2, pstmt2, con2);
		         }
		      }
		      
		      String sql = "select *from (" + 
		            "select * from (" + 
		            "select rownum rnum,num,title,id,to_char(writeday, 'yyyy/mm/dd') writeday," + 
		            "readcnt, repRoot, repStep, repIndent,content " + 
		            "from (select * from board where "+option+" like ? order by repRoot desc, repStep asc )) " + 
		            "where rnum between ? and ?)";
		      
		      try {
		         
		         con = dataFactory.getConnection();
		         pstmt = con.prepareStatement(sql);
		         pstmt.setString(1, "%" + searchtext + "%");
		         pstmt.setInt(2, to.getStartNum());
		         pstmt.setInt(3, to.getEndNum());
		         rs = pstmt.executeQuery();

		         while (rs.next()) {
		            int num = rs.getInt("num");
		            String title = rs.getString("title");
		            String id = rs.getString("id");
		            String writeday = rs.getString("writeday");
		            int readcnt = rs.getInt("readcnt");
		            int repStep = rs.getInt("repStep");
		            int repRoot = rs.getInt("repRoot");
		            int repIndent = rs.getInt("repIndent");
		            String content = rs.getString("content");
		            int notice = 0;
		            BoardDTO dto = new BoardDTO(num, id, title, content, writeday, readcnt, repRoot, 
		                  repStep, repIndent,   notice);
		            list.add(dto);
		         }

		         to.setList(list);
		         
		      } catch (Exception e) {
		         e.printStackTrace();
		      } finally {
		         closeAll(rs, pstmt, con);
		      }

		      return to;
		   }
		public int maxnum() {
			int num=0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "select max(num) from board";
			
			try {
				con = dataFactory.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					num = rs.getInt(1);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll(rs, pstmt, con);
			}
			return num;
		}
}
