package com.socket.service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class DirectoryWatcherService {

	private final SimpMessagingTemplate simpMessagingTemplate;

	public DirectoryWatcherService(SimpMessagingTemplate simpMessagingTemplate) {
		this.simpMessagingTemplate = simpMessagingTemplate;
		watchDirectory();
	}

	private void watchDirectory() {
		String directoryPath = "D:\\\\Project Idea's";

		try {
			WatchService watchService = FileSystems.getDefault().newWatchService();
			Path path = Paths.get(directoryPath);
			path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

			new Thread(() -> {
				while (true) {
					WatchKey key;
					try {
						key = watchService.take();
					} catch (InterruptedException e) {
						return;
					}
					for (WatchEvent<?> event : key.pollEvents()) {
						if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
							String folderName = event.context().toString();
							System.out.println("new folder created : " + folderName);
							simpMessagingTemplate.convertAndSend("/topic/new-folder");
						}
					}
					key.reset();
				}
			}).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
