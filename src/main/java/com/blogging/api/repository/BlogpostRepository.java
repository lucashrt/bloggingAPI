package com.blogging.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogging.api.domain.Blogpost;

public interface BlogpostRepository extends JpaRepository<Blogpost, UUID> {

} 