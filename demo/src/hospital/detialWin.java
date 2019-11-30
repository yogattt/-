package hospital;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class detialWin extends JFrame{
	private static final long serialVersionUID = 1L;
	detialWin(int selectnum,info in,Connection connect,int x,int y,String v)
	{
		this.setTitle("����");
		this.setSize(600,400);
		this.setVisible(true);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		String column=in.columnName[selectnum][y];
		if(column.equals("DNO")||column.equals("NNO"))
			column="MNO";
		column="where "+column+"=\'"+v+"\'";
		for(int i=0;i<in.workertable.length;i++)
		{
			try {
				CallableStatement cs = connect.prepareCall("{call paging_cursor(?,?,?,?,?,?,?)}");
				// ��in?��ֵ
	            cs.setString(1, " "+in.tablename[i]+" ");// ������
	            cs.setInt(2, 20);// ����pagesize��ÿҳ��ʾ��������¼
	            cs.setInt(3, 1);// ����pagenow����ʾ�ڼ�ҳ��
	            cs.setString(4,column+" ");
	            // ��out?ע��
	            cs.registerOutParameter(5, oracle.jdbc.OracleTypes.CURSOR);
	            cs.registerOutParameter(6, oracle.jdbc.OracleTypes.INTEGER);
	            cs.registerOutParameter(7, oracle.jdbc.OracleTypes.INTEGER);
	            // ִ��
	            cs.execute();
	            ResultSet rs = (ResultSet) cs.getObject(5);
	            if(rs.next())
	            {
	            	String[][] values= {};
	            	DefaultTableModel tableModel = new DefaultTableModel(values,in.workertable[i]);
	            	JTable table=new JTable(tableModel);
	            	table.setRowHeight(30);
	            	JScrollPane scrollPane = new JScrollPane(table);
	        		this.add(scrollPane); //,BorderLayout.CENTER
	                table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	                scrollPane.setViewportView(table);
	                
	                List<String> lists=new ArrayList<String>();
                	for(String str : in.columnName[i])
                		lists.add(rs.getString(str));
                	tableModel.addRow(lists.toArray());
                	
	            	while (rs.next()) {
	                	List<String> list=new ArrayList<String>();
	                	for(String str : in.columnName[i])
	                		list.add(rs.getString(str));
	                	tableModel.addRow(list.toArray());
	                }
	            }
			} catch (SQLException e) {
			}
		}
	}
}