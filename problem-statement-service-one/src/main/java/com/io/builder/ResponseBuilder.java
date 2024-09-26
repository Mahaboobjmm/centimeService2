package com.io.builder;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.io.entity.Character;

@Component(value = "responseBuilderForCharacter")
public class ResponseBuilder {

	public List<Map<String, Object>> getNestedCharacters(List<Character> characters) {

		Map<Long, List<Character>> groupedByParent = characters.stream()
				.collect(Collectors.groupingBy(Character::getParentId));

		List<Map<String, Object>> nestedCharacters = new ArrayList<>();

		for (Map.Entry<Long, List<Character>> entry : groupedByParent.entrySet()) {
			Long parentId = entry.getKey();
			if (parentId == 0L || parentId == null) {
				for (Character root : entry.getValue()) {
					nestedCharacters.add(buildNestedCharacter(root, groupedByParent));
				}
			}
		}
		return nestedCharacters;
	}

	private Map<String, Object> buildNestedCharacter(Character character, Map<Long, List<Character>> groupedByParent) {
		Map<String, Object> result = new LinkedHashMap<>();
		result.put("Name", character.getName());

		if (groupedByParent.containsKey(character.getId())) {
			List<Map<String, Object>> subClasses = groupedByParent.get(character.getId()).stream()
					.map(subClass -> buildNestedCharacter(subClass, groupedByParent)).collect(Collectors.toList());
			result.put("SubClasses", subClasses);
		}

		return result;
	}

}
