//package com.bau.graduateprojects.qrstudentsattendance.auth0;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
//import org.springframework.security.oauth2.provider.token.TokenEnhancer;
//import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//
//import java.util.Arrays;
//
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {
//
//    private final UserDetailsService userDetailsService;
//
//    private final AuthenticationManager authenticationManager;
//
//    private final PasswordEncoder passwordEncoder;
//
//    public AuthorizationServer(@Qualifier("StudentService") UserDetailsService userDetailsService, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
//        this.userDetailsService = userDetailsService;
//        this.authenticationManager = authenticationManager;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Bean
//    public TokenStore tokenStore() {
//        return new InMemoryTokenStore();
//    }
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient("app")
//                .secret(passwordEncoder.encode("passApp"))
//                .authorizedGrantTypes("password", "refresh_token", "")
//                .resourceIds("app")
//                .scopes("READ", "WRITE")
//                .accessTokenValiditySeconds(60 * 30)
//                .refreshTokenValiditySeconds(-1); // means valid for ever
//
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
//        endpoints.tokenStore(tokenStore())
//                .accessTokenConverter(accessTokenConverter())
//                .authenticationManager(authenticationManager)
//                .userDetailsService(userDetailsService)
//                .tokenEnhancer(tokenEnhancerChain());
//    }
//
//    @Bean
//    public TokenEnhancerChain tokenEnhancerChain() {
//        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
//
//        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter(), customAccessTokenEnhancer()));
//
//        return tokenEnhancerChain;
//    }
//
//    @Bean
//    public DefaultTokenServices tokenServices() {
//        DefaultTokenServices tokenServices = new DefaultTokenServices();
//
//        tokenServices.setTokenStore(tokenStore());
//        tokenServices.setTokenEnhancer(customAccessTokenEnhancer());
//        tokenServices.setReuseRefreshToken(true);
//
//        return tokenServices;
//    }
//
//    @Bean
//    public JwtAccessTokenConverter accessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey("my-app");
//        return converter;
//    }
//
//    public TokenEnhancer customAccessTokenEnhancer() {
//        return new CustomTokenEnhancer();
//    }
//}
