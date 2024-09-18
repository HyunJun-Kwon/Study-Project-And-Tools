package Json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class MakingJson {

	public static String motherJumin = "670802-2999002";
	public static String fatherJumin = "670801-1999001";
	public static String[] kidJumins = { "080801-3000887", "090802-4000888", "100803-3000889" };
	public static String[] adultChildJumins = { "970801-1000997", "980802-1000998", "990803-1000999" };
	public static String[] kidBirth = { "080801", "090802", "100803" };
	public static String[] adultChildBirth = { "970801", "980802", "990803" };
	public static String[] kidGender = {"3000887", "4000888","3000889"};
	public static String[] adultChildGender = {"1000997", "4000888","3000889"};
	

	// 성별 남/여 를 리턴하는 메소드
	public static String genderCode(String jumin) {
		char genderCode = jumin.charAt(0);

		String gender;
		if (genderCode == '1' || genderCode == '3' || genderCode == '5') {
			gender = "남";
		} else if (genderCode == '2' || genderCode == '4' || genderCode == '6') {
			gender = "여";
		} else {
			gender = "잘못된 성별 코드입니다.";
		}

		return gender;
	}

	// 주민등록번호 앞자리로 생년월일 만드는 메소드
	public static String convertBirth(String jumin) {
		DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyMMdd");
		DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy년MM월dd일");

		LocalDate date = LocalDate.parse(jumin, inputFormat);

		String birth = date.format(outputFormat);

		return birth;
	}

	public static void main(String[] args) {

		// 저장할 문서코드 ex) SIT58
		String docCode = "SIT1";

		// csv 파일 경로 저장
		// csv파일을 UTF-8로 인코딩설정해서 저장해줘야 한글을 깨지지 않고 읽어옴
		String csvFile = "D:\\CSV\\DataInput2.csv";

		// 데이터를 저장할 HashMap
		Map<String, String> dataMap = new HashMap<>();

		// csv 파일 읽기
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(csvFile), StandardCharsets.UTF_8))) {
			String headerLine = br.readLine();
			String valueLine = br.readLine();

			if (headerLine != null && valueLine != null) {
				String[] headers = headerLine.split(","); // 데이터 설명
				String[] values = valueLine.split(","); // 데이터 값

				// HashMap에 key value 저장
				for (int i = 0; i < headers.length; i++) {
					if (i < values.length && !values[i].trim().isEmpty()) {
						// value에서 따옴표 제거 후 저장
						String valueWithoutQuotes = values[i].replaceAll("\"", "");
						dataMap.put(headers[i], valueWithoutQuotes);
					} else {
						dataMap.put(headers[i], ""); // 빈 값 처리
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// map의 데이터 출력 ( 확인용 )
		for (Map.Entry<String, String> entry : dataMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}

		try {
			CRRE(dataMap, docCode);
			CRR(dataMap, docCode);
			CFR(dataMap, docCode);
			CNHIE(dataMap, docCode);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 주민등록초본
	public static void CRRE(Map<String, String> dataMap, String docCode) {
		StringBuilder jsonBuilder = new StringBuilder();

		// Json 시작
		jsonBuilder.append("{\n");

		jsonBuilder.append("  \"EMSG\": \"\",\n");

		// 차주이름 (CSV데이터)
		jsonBuilder.append("  \"SCNAME\": \"").append(dataMap.get("이름")).append("\",\n");

		// json 데이터 안에 배열이 있는 경우
		// 배열 시작
		jsonBuilder.append("  \"CJUSOLIST\": [\n");

		jsonBuilder.append("    {\n");
		jsonBuilder.append("      \"TRANSFERDATE\": \"\",\n");
		jsonBuilder.append("      \"TRANSFERADDR\": \"경기도 부천시 범안로 96번길 23 힐스테이트 4단지 404동 802호\",\n");
		jsonBuilder.append("      \"INDEX\": \"1\",\n");
		jsonBuilder.append("      \"CHANGEDATE\": \"19720629\",\n");
		jsonBuilder.append("      \"CHANGEREASON\": \"출생등록\",\n");
		jsonBuilder.append("      \"RELATION\": \"업무테스트\"\n");
		jsonBuilder.append("    },\n");

		// 두 번째 객체 추가
		jsonBuilder.append("    {\n");
		jsonBuilder.append("      \"TRANSFERDATE\": \"19740731\",\n");
		jsonBuilder.append("      \"TRANSFERADDR\": \"경기도 광명시 새터로 44-7 광명아크포레자이위브 1104동 1401호\",\n");
		jsonBuilder.append("      \"INDEX\": \"2\",\n");
		jsonBuilder.append("      \"CHANGEDATE\": \"19880731\",\n");
		jsonBuilder.append("      \"CHANGEREASON\": \"전입\",\n");
		jsonBuilder.append("      \"RELATION\": \"업무테스트\"\n");
		jsonBuilder.append("    }\n");

		// 배열 끝
		jsonBuilder.append("  ],\n");

		jsonBuilder.append("  \"OUTPUT_CONVERSION_CUSTOMER\": \"scbank\",\n");
		jsonBuilder.append("  \"PROCESS_ID\": \"0\",\n");
		jsonBuilder.append("  \"ERRDOC\": \"\",\n");
		jsonBuilder.append("  \"CERTKEY\": \"\",\n");
		jsonBuilder.append("  \"ECODE\": \"\",\n");
		jsonBuilder.append("  \"OFFICE\": \"서울특별시 양천구 신정6동\",\n");
		jsonBuilder.append("  \"SCBIRTH\": \"").append(dataMap.get("주민등록번호1")).append("\",\n");
		jsonBuilder.append("  \"ISSUEDATE\": \"20200724\",\n");
		jsonBuilder.append("  \"JUMIN\": \"").append(dataMap.get("주민등록번호1")).append(dataMap.get("주민등록번호2"))
				.append("\",\n");

		// 병역 관련 삭제해도 되는지 테스트 필요
		jsonBuilder.append("  \"ARMYLIST\": \"[]\",\n");

		jsonBuilder.append("  \"RESULT\": \"SUCCESS\",\n");
		jsonBuilder.append("  \"FCODE\": \"MLMWGM\",\n");
		jsonBuilder.append("  \"MODULE\": \"64\",\n");
		jsonBuilder.append("  \"FUNCNAME\": \"\",\n");
		jsonBuilder.append("  \"VERSCR\": \"\",\n");
		jsonBuilder.append("  \"NAME\": \"").append(dataMap.get("이름")).append("\",\n");
		jsonBuilder.append("  \"OFFICETELNUM\": \"0226204285\",\n");
		jsonBuilder.append("  \"REQNUMBER\": \"1595578608210829\",\n");
		jsonBuilder.append("  \"INJUKLIST\": \"[]\",\n");
		jsonBuilder.append("  \"ERRMSG\": \"\",\n");
		jsonBuilder.append("  \"ETRACK\": \"\",\n");
		jsonBuilder.append("  \"HANJANAME\": \"000000000000000000000000\",\n");
		jsonBuilder.append("  \"rsp_code\": \"200\",\n");
		jsonBuilder.append("  \"rsp_msg\": \"정상\"\n");

		// Json 끝
		jsonBuilder.append("}");

		// JSON 파일로 저장
		try (Writer file = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("D:\\CSV\\초본_" + docCode + ".json"), StandardCharsets.UTF_8))) {
			file.write(jsonBuilder.toString());
			System.out.println("주민등록초본 생성완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 주민등록등본
	public static void CRR(Map<String, String> dataMap, String docCode) {

		// ** 차주가 부모님인 경우는 고려되어 있지 않음. 기본적인 데이터로 json 생성 후 수정 필요

		StringBuilder jsonBuilder = new StringBuilder();

		// Json 시작
		jsonBuilder.append("{\n");

		jsonBuilder.append("  \"EMSG\": \"\",\n");
		jsonBuilder.append("  \"TRANSFERDATE\": \"\",\n");
		jsonBuilder.append("  \"SCNAME\": \"업무테스트\",\n");

		// 0 개수는 문서비교를 통해서 확인
		jsonBuilder.append("  \"SEDAEJUHANJANAME\": \"000000000000000000000000\",\n");
		jsonBuilder.append("  \"OUTPUT_CONVERSION_CUSTOMER\": \"scbank\",\n");
		jsonBuilder.append("  \"SEDAEJUNAME\": \"업무테스트\",\n");
		jsonBuilder.append("  \"PROCESS_ID\": \"0\",\n");
		jsonBuilder.append("  \"ERRDOC\": \"\",\n");
		jsonBuilder.append("  \"CERTKEY\": \"\",\n");
		jsonBuilder.append("  \"ECODE\": \"\",\n");
		jsonBuilder.append("  \"SEDAEGUSEONGDATE\": \"20000217\",\n");
		jsonBuilder.append("  \"HYEONJUSO\": \"서울특별시 양천구 목동서로 신정동, 목동신시가지아파트\",\n");
		jsonBuilder.append("  \"OFFICE\": \"서울특별시 양천구 신정6동\",\n");
		jsonBuilder.append("  \"CHANGEREASON\": \"전입\",\n");
		jsonBuilder.append("  \"SCBIRTH\": \"").append(dataMap.get("주민등록번호1")).append("\",\n");
		jsonBuilder.append("  \"CHANGEDATE\": \"20200619\",\n");
		jsonBuilder.append("  \"ISSUEDATE\": \"20200724\",\n");
		jsonBuilder.append("  \"RESULT\": \"SUCCESS\",\n");

		// JSON 배열

		int totalObjects = 1; // 차주 정보는 항상 존재하므로 1부터 시작

		if (dataMap.get("아버지 존재여부") != null && dataMap.get("아버지 존재여부").equals("2"))
			totalObjects++;
		if (dataMap.get("어머니 존재여부") != null && dataMap.get("어머니 존재여부").equals("2"))
			totalObjects++;
		if (dataMap.get("배우자 이름") != null)
			totalObjects++;

		if (dataMap.get("성년자녀수") != null) {
			totalObjects += Integer.parseInt(dataMap.get("성년자녀수"));
		}

		if (dataMap.get("미성년자녀수") != null) {
			totalObjects += Integer.parseInt(dataMap.get("미성년자녀수"));
		}

		// 객체 추가 시 마지막 객체일 경우 쉼표 제외
		int objectCounter = 0;

		jsonBuilder.append("  \"SEDAELIST\": [\n");

		// 차주 정보
		jsonBuilder.append("    {\n");
		jsonBuilder.append("      \"SEDAEJURELATION\": \"본인\",\n");
		jsonBuilder.append("      \"HANJANAME\": \"000000000000000000000000\",\n");
		jsonBuilder.append("      \"REGSTATE\": \"거주자\",\n");
		jsonBuilder.append("      \"TRANSFERDATE\": \"\",\n");
		jsonBuilder.append("      \"CHANGEREASON\": \"세대주변경\",\n");
		jsonBuilder.append("      \"JUMIN\": \"").append(dataMap.get("주민등록번호1")).append("-")
				.append(dataMap.get("주민등록번호2")).append("\",\n");
		jsonBuilder.append("      \"NAME\": \"업무테스트\",\n");
		jsonBuilder.append("      \"INDEX\": \"1\",\n");
		jsonBuilder.append("      \"CHANGEDATE\": \"20200619\"\n");
		jsonBuilder.append("    }");
		objectCounter++;
		if (objectCounter < totalObjects)
			jsonBuilder.append(",\n");

		// 아버지가 안계실 경우 1 존재할 경우 2
		if (dataMap.get("아버지 존재여부") == "2") {
			// 아버지 데이터

			jsonBuilder.append("    {\n");
			jsonBuilder.append("      \"SEDAEJURELATION\": \"부\",\n");
			jsonBuilder.append("      \"HANJANAME\": \"000000000000000000000000\",\n");
			jsonBuilder.append("      \"REGSTATE\": \"거주자\",\n");
			jsonBuilder.append("      \"TRANSFERDATE\": \"\",\n");
			jsonBuilder.append("      \"CHANGEREASON\": \"세대주변경\",\n");
			jsonBuilder.append("      \"JUMIN\": \"").append(fatherJumin).append(",\n");
			jsonBuilder.append("      \"NAME\": \"업무테스트\",\n");
			jsonBuilder.append("      \"INDEX\": \"1\",\n");
			jsonBuilder.append("      \"CHANGEDATE\": \"20200619\"\n");
			jsonBuilder.append("    }");
			objectCounter++;
			if (objectCounter < totalObjects)
				jsonBuilder.append(",\n");
		}

		if (dataMap.get("어머니 존재여부") == "2") {

			// 어머니 데이터

			jsonBuilder.append("    {\n");
			jsonBuilder.append("      \"SEDAEJURELATION\": \"모\",\n");
			jsonBuilder.append("      \"HANJANAME\": \"000000000000000000000000\",\n");
			jsonBuilder.append("      \"REGSTATE\": \"거주자\",\n");
			jsonBuilder.append("      \"TRANSFERDATE\": \"\",\n");
			jsonBuilder.append("      \"CHANGEREASON\": \"세대주변경\",\n");
			jsonBuilder.append("      \"JUMIN\": \"").append(motherJumin).append(",\n");
			jsonBuilder.append("      \"NAME\": \"업무테스트\",\n");
			jsonBuilder.append("      \"INDEX\": \"1\",\n");
			jsonBuilder.append("      \"CHANGEDATE\": \"20200619\"\n");
			jsonBuilder.append("    }");
			objectCounter++;
			if (objectCounter < totalObjects)
				jsonBuilder.append(",\n");
		}

		if (dataMap.get("배우자 이름") != null) {
			// 배우자가 있을 경우 배우자 데이터 출력
			jsonBuilder.append("    {\n");
			jsonBuilder.append("      \"SEDAEJURELATION\": \"배우자\",\n");
			jsonBuilder.append("      \"HANJANAME\": \"000000000000000000000000\",\n");
			jsonBuilder.append("      \"REGSTATE\": \"거주자\",\n");
			jsonBuilder.append("      \"TRANSFERDATE\": \"\",\n");
			jsonBuilder.append("      \"CHANGEREASON\": \"세대주변경\",\n");
			jsonBuilder.append("      \"JUMIN\": \"").append(dataMap.get("배우자 주민번호1")).append("-")
					.append(dataMap.get("배우자 주민번호2")).append("\",\n");
			jsonBuilder.append("      \"NAME\": \"업무테스트\",\n");
			jsonBuilder.append("      \"INDEX\": \"1\",\n");
			jsonBuilder.append("      \"CHANGEDATE\": \"20200619\"\n");
			jsonBuilder.append("    }");
			objectCounter++;
			if (objectCounter < totalObjects)
				jsonBuilder.append(",\n");
		}

		if (dataMap.get("성년자녀수") != null) {
			// 성년 자녀가 있을 경우 성년자녀수 만큼 데이터 출력

			int count = Integer.parseInt(dataMap.get("성년자녀수"));

			// 성년자녀는 3명까지만 되도 충분할 것 같아 3개만 준비
			if (count < 4) {
				for (int i = 0; i < count; i++) {
					jsonBuilder.append("    {\n");
					jsonBuilder.append("      \"SEDAEJURELATION\": \"자녀\",\n");
					jsonBuilder.append("      \"HANJANAME\": \"000000000000000000000000\",\n");
					jsonBuilder.append("      \"REGSTATE\": \"거주자\",\n");
					jsonBuilder.append("      \"TRANSFERDATE\": \"\",\n");
					jsonBuilder.append("      \"CHANGEREASON\": \"세대주변경\",\n");
					jsonBuilder.append("      \"JUMIN\": \"").append(adultChildJumins[i]).append("\",\n");
					jsonBuilder.append("      \"NAME\": \"업무테스트\",\n");
					jsonBuilder.append("      \"INDEX\": \"1\",\n");
					jsonBuilder.append("      \"CHANGEDATE\": \"20200619\"\n");
					jsonBuilder.append("    }");
					objectCounter++;
					if (objectCounter < totalObjects)
						jsonBuilder.append(",\n");
				}
			}
		}

		if (dataMap.get("미성년자녀수") != null) {
			// 성년 자녀가 있을 경우 성년자녀수 만큼 데이터 출력

			int count = Integer.parseInt(dataMap.get("성년자녀수"));

			// 미성년자녀는 3명까지만 되도 충분할 것 같아 3개만 준비
			if (count < 4) {
				for (int i = 0; i < count; i++) {
					jsonBuilder.append("    {\n");
					jsonBuilder.append("      \"SEDAEJURELATION\": \"자녀\",\n");
					jsonBuilder.append("      \"HANJANAME\": \"000000000000000000000000\",\n");
					jsonBuilder.append("      \"REGSTATE\": \"거주자\",\n");
					jsonBuilder.append("      \"TRANSFERDATE\": \"\",\n");
					jsonBuilder.append("      \"CHANGEREASON\": \"세대주변경\",\n");
					jsonBuilder.append("      \"JUMIN\": \"").append(kidJumins[i]).append("\",\n");
					jsonBuilder.append("      \"NAME\": \"업무테스트\",\n");
					jsonBuilder.append("      \"INDEX\": \"1\",\n");
					jsonBuilder.append("      \"CHANGEDATE\": \"20200619\"\n");
					jsonBuilder.append("    }");
					objectCounter++;
					if (objectCounter < totalObjects)
						jsonBuilder.append(",\n");
				}
			}
		}
		// 배열 끝
		jsonBuilder.append("  ],\n");

		// 주소 리스트 배열 시작
		jsonBuilder.append("  \"DJUSOLIST\": [\n");

		jsonBuilder.append("    {\n");
		jsonBuilder.append("      \"TRANSFERDATE\": \"20150820\",\n");
		jsonBuilder.append("      \"TRANSFERADDR\": \"서울특별시 양천구 목동서로 280, 804호 1701호\",\n");
		jsonBuilder.append("      \"INDEX\": \"1\",\n");
		jsonBuilder.append("      \"CHANGEDATE\": \"20150820\",\n");
		jsonBuilder.append("      \"CHANGEREASON\": \"전입\"\n");
		jsonBuilder.append("    },\n");

		// 두 번째 객체 추가
		jsonBuilder.append("    {\n");
		jsonBuilder.append("      \"TRANSFERDATE\": \"20150820\",\n");
		jsonBuilder.append("      \"TRANSFERADDR\": \"서울특별시 양천구 목동서로 280, 804호 1701호\",\n");
		jsonBuilder.append("      \"INDEX\": \"1\",\n");
		jsonBuilder.append("      \"CHANGEDATE\": \"20150820\",\n");
		jsonBuilder.append("      \"CHANGEREASON\": \"전입\"\n");
		jsonBuilder.append("    }\n");

		// 배열 끝
		jsonBuilder.append("  ],\n");

		jsonBuilder.append("  \"FUNCNAME\": \"\",\n");
		jsonBuilder.append("  \"FCODE\": \"MLMWGM\",\n");
		jsonBuilder.append("  \"VERSCR\": \"\",\n");
		jsonBuilder.append("  \"MODULE\": \"63\",\n");
		jsonBuilder.append("  \"OFFICETELNUM\": \"022624285\",\n");
		jsonBuilder.append("  \"REQNUMBER\": \"1595578585697882\",\n");
		jsonBuilder.append("  \"ERRMSG\": \"\",\n");
		jsonBuilder.append("  \"ETRACK\": \"\",\n");
		jsonBuilder.append("  \"SEDAEGUSEONGREASON\": \"세대주변경\",\n");
		jsonBuilder.append("  \"rsp_code\": \"200\",\n");
		jsonBuilder.append("  \"rsp_msg\": \"정상\"\n");

		// Json 끝
		jsonBuilder.append("}");

		// JSON 파일로 저장
//		try (FileWriter file = new FileWriter("D:\\CSV\\등본_" + docCode + ".json", StandardCharsets.UTF_8)) {
//			file.write(jsonBuilder.toString());
//			file.flush();
//
//			System.out.println("주민등록등본 생성완료");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		// outputstream 사용
		try (Writer file = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("D:\\CSV\\등본_" + docCode + ".json"), StandardCharsets.UTF_8))) {
			file.write(jsonBuilder.toString());
			System.out.println("주민등록등본 생성완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 가족관계증명서
	public static void CFR(Map<String, String> dataMap, String docCode) {
		StringBuilder jsonBuilder = new StringBuilder();

		// Json 시작
		jsonBuilder.append("{\n");

		jsonBuilder.append("  \"ERRMSG\": \"\",\n");
		jsonBuilder.append("  \"ERRDOC\": \"\",\n");
		jsonBuilder.append("  \"RESULT\": \"SUCCESS\",\n");
		jsonBuilder.append("  \"ECODE\": \"\",\n");
		jsonBuilder.append("  \"EMSG\": \"\",\n");
		jsonBuilder.append("  \"CERTKEY\": \"\",\n");
		jsonBuilder.append("  \"FUNCNAME\": \"\",\n");
		jsonBuilder.append("  \"ETRACK\": \"\",\n");
		jsonBuilder.append("  \"VERSCR\": \"\",\n");

		// 차주 배열 시작
		jsonBuilder.append("  \"FAMILYCERT\": \n");

		// 주민번호를 날짜형식으로 변경

		jsonBuilder.append("    {\n");
		jsonBuilder.append("      \"FCADDR\": \"광주광역시 광산구**********\",\n");
		jsonBuilder.append("      \"FCGUBUN\": \"본인\",\n");
		jsonBuilder.append("      \"FCNAME\": \"업무테스트\",\n");
		jsonBuilder.append("      \"FCBIRTHDAY\": \"").append(convertBirth(dataMap.get("주민등록번호1"))).append("\",\n");
		jsonBuilder.append("      \"FCHANJABG\": \"0000000000000000\",\n");
		jsonBuilder.append("      \"FCREGCNFIRM\": \"[]\",\n");
		jsonBuilder.append("      \"FCHANJANAME\": \"000000000000000000000000\",\n");
		jsonBuilder.append("      \"FCGENDER\": \"남\",\n");
		jsonBuilder.append("      \"FCJUMIN\": \"").append(dataMap.get("주민등록번호1")).append("-")
				.append(dataMap.get("주민등록번호2")).append("\",\n");

		// 가족정보 입력 배열

		jsonBuilder.append("      \"FCFAMILYCNFIRM\": [\n");

		int totalObjects = 0; // 차주 정보는 항상 존재하므로 1부터 시작

		if (dataMap.get("아버지 존재여부") != null && dataMap.get("아버지 존재여부").equals("2"))
			totalObjects++;
		if (dataMap.get("어머니 존재여부") != null && dataMap.get("어머니 존재여부").equals("2"))
			totalObjects++;
		if (dataMap.get("배우자 이름") != null)
			totalObjects++;

		if (dataMap.get("성년자녀수") != null) {
			totalObjects += Integer.parseInt(dataMap.get("성년자녀수"));
		}

		if (dataMap.get("미성년자녀수") != null) {
			totalObjects += Integer.parseInt(dataMap.get("미성년자녀수"));
		}
		
		// 객체 추가 시 마지막 객체일 경우 쉼표 제외
		int objectCounter = 0;

		// 아버지가 안계실 경우 1 존재할 경우 2
		if (dataMap.get("아버지 존재여부").equals("2")) {
			// 아버지 데이터

			jsonBuilder.append("        {\n");
			jsonBuilder.append("          \"FCNGUBUN\": \"부\",\n");
			jsonBuilder.append("          \"FCNJUMIN\": \"").append(fatherJumin).append(",\n");
			jsonBuilder.append("          \"FCNDEATHYN\": \"N\",\n");
			jsonBuilder.append("          \"FCNNAME\": \"업무테스트\",\n");
			jsonBuilder.append("          \"FCGENDER\": \"").append(genderCode(dataMap.get("주민등록번호2"))).append(",\n");
			jsonBuilder.append("          \"FCNHANJABG\": \"0000000000000000\",\n");
			jsonBuilder.append("          \"FCNHANJANAME\": \"000000000000000000000000\",\n");
			jsonBuilder.append("          \"FCNBIRTHDAY\": \"1967년08월01일\"\n");
			jsonBuilder.append("        }");
			objectCounter++;
			if (objectCounter < totalObjects)
				jsonBuilder.append(",\n");
		}
		
		// 어머니가 안계실 경우 1 존재할 경우 2
		if (dataMap.get("어머니 존재여부").equals("2")) {

			// 어머니 데이터

			jsonBuilder.append("        {\n");
			jsonBuilder.append("          \"FCNGUBUN\": \"모\",\n");
			jsonBuilder.append("          \"FCNJUMIN\": \"").append(motherJumin).append(",\n");
			jsonBuilder.append("          \"FCNDEATHYN\": \"N\",\n");
			jsonBuilder.append("          \"FCNNAME\": \"업무테스트\",\n");
			jsonBuilder.append("          \"FCNGENDER\": \"여\",\n");
			jsonBuilder.append("          \"FCNHANJABG\": \"0000000000000000\",\n");
			jsonBuilder.append("          \"FCNHANJANAME\": \"000000000000000000000000\",\n");
			jsonBuilder.append("          \"FCNBIRTHDAY\": \"1967년08월02일\"\n");
			jsonBuilder.append("        }");
			objectCounter++;
			if (objectCounter < totalObjects)
				jsonBuilder.append(",\n");
		}

		if (dataMap.get("배우자 이름") != null) {
			
			// 배우자가 있을 경우 배우자 데이터 출력
			jsonBuilder.append("        {\n");
			jsonBuilder.append("          \"FCNGUBUN\": \"배우자\",\n");
			jsonBuilder.append("          \"JUMIN\": \"").append(dataMap.get("배우자 주민번호1")).append("-")
					.append(dataMap.get("배우자 주민번호2")).append("\",\n");
			jsonBuilder.append("          \"FCNDEATHYN\": \"N\",\n");
			jsonBuilder.append("          \"FCNNAME\": \"업무테스트\",\n");
			jsonBuilder.append("          \"FCNGENDER\": \"").append(genderCode(dataMap.get("배우자 주민번호2")))
					.append("\",\n");
			jsonBuilder.append("          \"FCNHANJABG\": \"0000000000000000\",\n");
			jsonBuilder.append("          \"FCNHANJANAME\": \"000000000000000000000000\",\n");
			jsonBuilder.append("          \"FCNBIRTHDAY\": \"").append(convertBirth(dataMap.get("배우자 주민번호1")))
					.append("\"\n");
			jsonBuilder.append("        }");
			objectCounter++;
			if (objectCounter < totalObjects)
				jsonBuilder.append(",\n");
		}

		if (dataMap.get("성년자녀수") != null) {
			// 성년 자녀가 있을 경우 성년자녀수 만큼 데이터 출력

			int count = Integer.parseInt(dataMap.get("성년자녀수"));

			// 성년자녀는 3명까지만 되도 충분할 것 같아 3개만 준비
			if (count < 4) {
				for (int i = 0; i < count; i++) {
					jsonBuilder.append("        {\n");
					jsonBuilder.append("          \"FCNGUBUN\": \"자녀\",\n");
					jsonBuilder.append("          \"FCNJUMIN\": \"").append(adultChildJumins[i]).append("\",\n");
					jsonBuilder.append("          \"FCNDEATHYN\": \"N\",\n");
					jsonBuilder.append("          \"FCNNAME\": \"업무테스트\",\n");
					jsonBuilder.append("          \"FCNGENDER\": \"")
			           .append(genderCode(adultChildGender[i]))
			           .append("\",\n");
					jsonBuilder.append("          \"FCNHANJABG\": \"0000000000000000\",\n");
					jsonBuilder.append("          \"FCNHANJANAME\": \"000000000000000000000000\",\n");
					jsonBuilder.append("          \"FCNBIRTHDAY\": \"").append(convertBirth(adultChildBirth[i]))
							.append("\"\n");
					jsonBuilder.append("        }");
					objectCounter++;
					if (objectCounter < totalObjects)
						jsonBuilder.append(",\n");
				}
			}
		}

		if (dataMap.get("미성년자녀수") != null) {
			// 성년 자녀가 있을 경우 성년자녀수 만큼 데이터 출력

			int count = Integer.parseInt(dataMap.get("성년자녀수"));

			// 미성년자녀는 3명까지만 되도 충분할 것 같아 3개만 준비
			if (count < 4) {
				for (int i = 0; i < count; i++) {
					jsonBuilder.append("        {\n");
					jsonBuilder.append("          \"FCNGUBUN\": \"자녀\",\n");
					jsonBuilder.append("          \"FCNJUMIN\": \"").append(kidJumins[i]).append("\",\n");
					jsonBuilder.append("          \"FCNDEATHYN\": \"N\",\n");
					jsonBuilder.append("          \"FCNNAME\": \"업무테스트\",\n");
					jsonBuilder.append("          \"FCNGENDER\": \"").append(genderCode(kidGender[i])).append("\",\n");
					jsonBuilder.append("          \"FCNHANJABG\": \"0000000000000000\",\n");
					jsonBuilder.append("          \"FCNHANJANAME\": \"000000000000000000000000\",\n");
					jsonBuilder.append("          \"FCNBIRTHDAY\": \"").append(convertBirth(kidBirth[i]))
							.append("\"\n");
					jsonBuilder.append("        }");
					objectCounter++;
					if (objectCounter < totalObjects)
						jsonBuilder.append(",\n");
				}
			}
		}

		// 가족정보 배열끝
		jsonBuilder.append("\n");
		jsonBuilder.append("      ]\n");

		// 차주 배열 끝
		jsonBuilder.append("    },\n");

		jsonBuilder.append("  \"requestFCODE\": \"MLFRGM\",\n");
		jsonBuilder.append("  \"requestMODULE\": \"1\",\n");
		jsonBuilder.append("  \"VERCORE\": \"3.2.42.2020110400\",\n");
		jsonBuilder.append("  \"PROCESS_ID\": \"0\",\n");
		jsonBuilder.append("  \"OUTPUT_CONVERSION_CUSTOMER\": \"scbank\",\n");
		jsonBuilder.append("  \"rsp_code\": \"200\",\n");
		jsonBuilder.append("  \"rsp_msg\": \"정상\"\n");

		// 배열 끝
		

		// Json 끝
		jsonBuilder.append("}");

		// outputstream 사용
		try (Writer file = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("D:\\CSV\\가족_" + docCode + ".json"), StandardCharsets.UTF_8))) {
			file.write(jsonBuilder.toString());
			System.out.println("가족관계증명서 생성완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 건보납부자격확인서
	public static void CNHIE(Map<String, String> dataMap, String docCode) {
		StringBuilder jsonBuilder = new StringBuilder();

		// Json 시작
		jsonBuilder.append("{\n");

		jsonBuilder.append("  \"rsp_code\": \"200\",\n");
		jsonBuilder.append("  \"rsp_msg\": \"정상\",\n");

		// 배열 시작
		jsonBuilder.append("  \"resData\": {\n");

		
		jsonBuilder.append("      \"RSPNS_CD\": \"200\",\n");
		jsonBuilder.append("      \"RSPNS\": \"100_정상 처리되었습니다.\",\n");
		
		// 안의 2번째 배열 시작
		jsonBuilder.append("      \"hlth_info\": {\n");
		jsonBuilder.append("            \"ISSUE_DT\": \"20240723\",\n");
		jsonBuilder.append("            \"ISSUE_INSTITUTN_BOSS\": \"국민건강보험공단 이사장\",\n");
		jsonBuilder.append("            \"NM\": \"업무테스트\",\n");
		jsonBuilder.append("            \"SSN\": \"").append(dataMap.get("주민등록번호1")).append(dataMap.get("주민등록번호2"))
		.append("\",\n");
		
		// 안의 3번째 배열 시작
		jsonBuilder.append("            \"hlth_list\": [{\n");
		jsonBuilder.append("                \"HLDR_MK\": \"").append(dataMap.get("가입구분")).append("\",").append(" \"BIZMAN_TITL\": \"").append(dataMap.get("직장명")).append("\",")
		.append(" \"QLFCTN_ACQSTN\": \"").append(dataMap.get("자격취득일")).append("\",")
		.append(" \"QLFCTN_LOSS\": \"99991231").append("\",")
		.append(" \"BIZ_PLC_TELNO\": \"02-111-1111").append("\"");
		
		jsonBuilder.append("            \n");
		jsonBuilder.append("            }]\n");
		
		jsonBuilder.append("      }\n");
		
		// 배열 끝
		jsonBuilder.append("  }\n");
		
		// Json 끝
		jsonBuilder.append("}");
		
		try (Writer file = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("D:\\CSV\\MDS1791_" + docCode + ".json"), StandardCharsets.UTF_8))) {
			file.write(jsonBuilder.toString());
			System.out.println("건보자격확인서 생성완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 건보납부확인서
	public static void CNHICP(Map<String, String> dataMap) {

		// 건보 납부 확인서의 경우 직장가입자와 그외로 나누어서 개인용과 기업용으로 구분해야한다.
		
		if(dataMap.get("가입구분").equals("직장가입자")) {
			
		}
		
	}


}
