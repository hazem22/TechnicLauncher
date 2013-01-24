/*
 * This file is part of Spoutcraft.
 *
 * Copyright (c) 2011-2012, Spout LLC <http://www.spout.org/>
 * Spoutcraft is licensed under the Spout License Version 1.
 *
 * Spoutcraft is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the Spout License Version 1.
 *
 * Spoutcraft is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the Spout License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spoutcraft.launcher.technic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.spoutcraft.launcher.exceptions.RestfulAPIException;

public class Modpacks {

	@JsonProperty("modpacks")
	private Map<String, String> modpacks;

	public List<ModpackInfo> getModpacks() throws RestfulAPIException {
		List<ModpackInfo> modpackInfos = new ArrayList<ModpackInfo>(modpacks.size());
		for (String pack : modpacks.keySet()) {
			ModpackInfo info = TechnicRestAPI.getModpackInfo(pack);
			info.setDisplayName(modpacks.get(pack));
			modpackInfos.add(info);
		}
		return modpackInfos;
	}

	@Override
	public String toString() {
		return "{ Modpacks [modpacks: " + modpacks + "] }";
	}
}