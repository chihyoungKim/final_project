package com.inadang.service;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.inadang.domain.AuthVO;
import com.inadang.domain.MemberVO;
import com.inadang.mapper.MemberMapper;

import lombok.AllArgsConstructor;

@Service @AllArgsConstructor 
public class MemberServiceImpl implements MemberService{
	
	private MemberMapper mapper;
	private PasswordEncoder encoder;

	@Override
	public void joinMember(MemberVO vo) {
		vo.setPassword(encoder.encode(vo.getPassword()));
		mapper.insertMember(vo);
		AuthVO authVO = new AuthVO();
			authVO.setAuth("ROLE_MEMBER");
			authVO.setId(vo.getId());
		mapper.insertAuth(authVO);
	}
	
	@Override
	public void joinManager(MemberVO vo) {
		vo.setPassword(encoder.encode(vo.getPassword()));
		mapper.insertManager(vo);
		AuthVO authVO = new AuthVO();
			authVO.setAuth("ROLE_MANAGER");
			authVO.setId(vo.getId());
		mapper.insertAuth(authVO);
	}

	@Override
	public MemberVO get(String id) {
		return mapper.get(id);
	}


	@Override
	public void updateSno(String id, Long sno) {
		mapper.updateSno(id, sno);
	}

	@Override
	public boolean updateMember(MemberVO memberVO) {
		memberVO.setPassword(encoder.encode(memberVO.getPassword()));
		return mapper.updateMember(memberVO) > 0;
	}
	
	@Override
	public boolean updateManager(MemberVO memberVO) {
		memberVO.setPassword(encoder.encode(memberVO.getPassword()));
		return mapper.updateManager(memberVO) > 0;
	}
	


	

	@Override
	public void emailAuth(String id, String email) throws UnsupportedEncodingException, IllegalArgumentException {
		MemberVO memberVO = mapper.get(id);
		memberVO.setAuthToken(String.format("%08d", new Random().nextInt(100_000_000)));
		
		mapper.updateEmailAuthToken(memberVO);
		String host = "http://localhost:8080" + "/member/procAuth";
		String queryString = "id=" + memberVO.getId() + "&authToken = " + encoder.encode(memberVO.getAuthToken());
		
		String content = String.format("<table width='600' style='margin:0 auto'>\r\n" + 
				"        <tr>\r\n" + 
				"            <td align='center'><h1 style='text-align: center;'>이 메일은 본인 확인을 위한 이메일입니다.</h1></td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td><p style='color: #555555;'>이 메일의 소유자가 %s님 본일일 경우 아래의 링크를 클릭하세요.</p></td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td align='center'>\r\n" + 
				"                <div style='display: inline-block; padding: 8px; background-color: #222222;'>\r\n" + 
				"                    <a href='%s' style='text-decoration: none; color: #dddddd;'>인증하기</a>\r\n" + 
				"                </div>\r\n" + 
				"            </td>\r\n" + 
				"            \r\n" + 
				"        </tr>            \r\n" + 
				"    </table>", memberVO.getId(), host + "?" + queryString);
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("rbdnd1019@gmail.com", "rgaqgjmuihlscipb");
			}
		});
		String receiver = email;
		String title = "이메일 인증 주소 확인 메일입니다.";
		
		Message message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress("rbdnd1019@gmail.com", "관리자", "utf-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			message.setSubject(title);
			message.setContent(content, "text/html;charset=utf-8");
			
			Transport.send(message);
			
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int emailAuthToken(String id, String authToken) {
		MemberVO memberVO = mapper.get(id);
		String msg = "";
		memberVO.setEmailAuth(encoder.encode(memberVO.getAuthToken()) != null ? 1 : 0);
		if(memberVO.getEmailAuth() == 1) {
			mapper.updateEmailAuth(memberVO);
			msg = "이메일 인증이 성공적으로 완료되었습니다.";
		}
		else {
			msg = "이메일 인증에 실패했습니다."; 
		}
		return memberVO.getEmailAuth();
	}

	@Override
	public int delete(String id) {
		return mapper.deleteMember(id);
	}



	@Override
	public long getSno(String id) {
		return mapper.getSno(id);
	}

	
}
