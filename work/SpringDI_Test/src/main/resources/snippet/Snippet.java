package snippet;

public class Snippet {
	<!-- �ѱ� ó�� ���ڵ� -->
		<filter>
			<filter-name>CharsetEncoding</filter-name>
			<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
			<init-param>
				<param-name>encoding</param-name>
				<param-value>utf-8</param-value>
			</init-param>
		</filter>
	
		<filter-mapping>
			<filter-name>CharsetEncoding</filter-name>
			<url-pattern>/*</url-pattern>
		</filter-mapping>
}

