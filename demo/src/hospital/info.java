package hospital;

public class info {
	public  String[] tablename= {"MEDICALWORKER","PATIENT","MEDICALRECORDS","OFFICE",
			"PATIENT_WORKER","PSITE","HOSPITALRECORDS","ROOM"};
	public String [][]columnName= {
			{"MNO","MNAME","ONO","AGE","SEX","PROTITLE","MSTATE"},
			{"PANO","PNAME","AGE","SEX","ADDRESS","PHONE"},
			{"PANO","TREATEDATE","MRECORDS","MNO"},{"ONO","ONAME","DNO","NNO","PHONE"},
			{"PANO","DNO","NNO"},{"PANO","ONO","RNO","BNO"},
			{"PANO","INDATE","OUTDATE"},{"RNO","ONO","BEDNUM","RESTNUM"}};
	public String[] []workertable = {
			{"����","����","���Һ�","����","�Ա�","ְ��","״̬"},{"���","����","����","�Ա�","סַ","�绰"},
			{"���˱��","����ʱ��","���Ƽ�¼","�����˹���"},{"���Һ�","������","����","��ʿ��","�绰"},
			{"����","����ҽ��","����ʿ"},{"���˱��","���Һ�","������","������"},
			{"���˱��","סԺ����","��Ժ����"},{"������","��������","��������","���в�����"}};
	public String where=" ";
}
