package org.example.global.configratiron;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.domain.auth.model.Role;
import org.example.global.filter.ExceptionFilter;
import org.example.global.filter.JwtFilter;
import org.example.global.security.jwt.JwtParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtParser jwtParser;
    private final ObjectMapper objectMapper;

    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder () { return new BCryptPasswordEncoder(); }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests((authorization) -> {
                        // auth
                        authorization
                                .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                                .requestMatchers(HttpMethod.POST, "/auth/refresh").permitAll();

                        // post
                        authorization
                                .requestMatchers(HttpMethod.POST, "/student/signup").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/student").hasAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.POST, "/student/email/verify").permitAll()
                                .requestMatchers(HttpMethod.POST, "/student/email/send").permitAll()
                                .requestMatchers(HttpMethod.GET, "/student/my").hasAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.PATCH, "/student/profile").hasAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.PATCH, "/student/password").hasAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.GET, "/student/study").hasAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.GET, "/student/post").hasAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.GET, "/student/subject").hasAuthority(Role.Student.name());

                        // teacher
                        authorization
                                .requestMatchers(HttpMethod.POST, "/teacher").hasAnyAuthority(Role.Teacher.name(), Role.Head.name())
                                .requestMatchers(HttpMethod.DELETE, "/teacher/my").hasAnyAuthority(Role.Teacher.name(), Role.Head.name())
                                .requestMatchers(HttpMethod.PATCH, "/teacher/check").hasAnyAuthority(Role.Teacher.name(), Role.Head.name());

                        // post
                        authorization
                                .requestMatchers(HttpMethod.POST, "/post/create").hasAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.PATCH, "/post/{postId}").hasAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.DELETE, "/post/{postId}").hasAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.GET, "/post/detail/{postId}").hasAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.GET, "/post/search").hasAuthority(Role.Student.name());

                        // comment
                        authorization
                                .requestMatchers(HttpMethod.POST, "/comment/create/{postId}").hasAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.PATCH, "/comment/{commentId}").hasAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.DELETE, "/comment/{commentId}").hasAuthority(Role.Student.name());

                        // reply
                        authorization
                                .requestMatchers(HttpMethod.POST, "/reply/create/{commentId}").hasAnyAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.PATCH, "/reply/{replyId}").hasAnyAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.DELETE, "/reply/{replyId}").hasAnyAuthority(Role.Student.name());

                        // study
                        authorization
                                .requestMatchers(HttpMethod.POST, "/study").hasAnyAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.PATCH, "/study/{study_id}").hasAnyAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.DELETE, "/study/{study_id}").hasAnyAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.POST, "/study/join/{study_id}").hasAnyAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.DELETE, "/study/leave/{study_id}").hasAnyAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.DELETE, "/study/ban/{study_id}/{student_id}").hasAnyAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.GET, "/study/member/{study_id}").hasAnyAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.GET, "/study").hasAnyAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.GET, "/study/{study_id}").hasAnyAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.GET, "/study/my").hasAnyAuthority(Role.Student.name());

                        // todo
                        authorization
                                .requestMatchers(HttpMethod.POST, "/todo").hasAnyAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.PATCH, "/todo/{todo_id}").hasAnyAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.DELETE, "/todo/{todo_id}").hasAnyAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.PATCH, "/todo/toggle/{todo_id}").hasAnyAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.GET, "/todo").hasAnyAuthority(Role.Student.name());

                        // exam
                        authorization
                                .requestMatchers(HttpMethod.POST, "/exam/{exam_id}").hasAnyAuthority(Role.Teacher.name(), Role.Head.name())
                                .requestMatchers(HttpMethod.PATCH, "/exam/{exam_data_id}").hasAnyAuthority(Role.Teacher.name(), Role.Head.name())
                                .requestMatchers(HttpMethod.DELETE, "/exam/{exam_data_id}").hasAnyAuthority(Role.Teacher.name(), Role.Head.name())
                                .requestMatchers(HttpMethod.GET, "/exam/{exam_id}").permitAll()
                                .requestMatchers(HttpMethod.GET, "/exam/detail/{exam_data_id}").permitAll()
                                .requestMatchers(HttpMethod.POST, "/exam").hasAnyAuthority(Role.Teacher.name(), Role.Head.name())
                                .requestMatchers(HttpMethod.GET, "/exam").hasAnyAuthority(Role.Teacher.name(), Role.Head.name())
                                .requestMatchers(HttpMethod.DELETE, "/exam").hasAnyAuthority(Role.Teacher.name(), Role.Head.name());

                        // test
                        authorization
                                .requestMatchers(HttpMethod.POST, "/test").hasAnyAuthority(Role.Teacher.name(), Role.Head.name())
                                .requestMatchers(HttpMethod.PATCH, "/test/{test_id}").hasAnyAuthority(Role.Teacher.name(), Role.Head.name())
                                .requestMatchers(HttpMethod.DELETE, "/test/{test_id}").hasAnyAuthority(Role.Teacher.name(), Role.Head.name())
                                .requestMatchers(HttpMethod.GET, "/test/admin").hasAnyAuthority(Role.Teacher.name(), Role.Head.name())
                                .requestMatchers(HttpMethod.GET, "/test/student").hasAnyAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.GET, "/test/{test_id}").permitAll();

                        // util
                        authorization
                                .requestMatchers(HttpMethod.GET, "/util/teacher/subject").hasAnyAuthority(Role.Teacher.name(), Role.Head.name())
                                .requestMatchers(HttpMethod.GET, "/util/teacher/{subject_id}").hasAnyAuthority(Role.Teacher.name(), Role.Head.name())
                                .requestMatchers(HttpMethod.GET, "/util/student/subject").hasAnyAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.GET, "/util/student/optional").hasAnyAuthority(Role.Student.name())
                                .requestMatchers(HttpMethod.POST, "/util/file").permitAll();

                        authorization
                                .anyRequest().denyAll();
                })

                .sessionManagement(session
                        -> { session.sessionCreationPolicy(SessionCreationPolicy.STATELESS); }
                )

                .headers(header
                        -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
                )

                .addFilterBefore(new JwtFilter(jwtParser), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new ExceptionFilter(objectMapper), JwtFilter.class)

                .build();
    }
}