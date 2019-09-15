package pl.terminal.server.domain.traveler.profile.nationality;

import org.springframework.stereotype.Service;
import pl.terminal.server.domain.traveler.profile.Avatar;

@Service
public class CountryAvatarService {

	public Avatar getAvatar(Nationality key) {
		switch (key) {
			case EGYPT:
				return new Avatar(
						"PHN2ZyB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIHZpZXdCb3g9IjAgMCA2NCA2NCIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPGNpcmNsZSBjeD0iMzIiIGN5PSIzMiIgcj0iMzIiIGZpbGw9InVybCgjcGFpbnQwX2xpbmVhcikiLz4KPG1hc2sgaWQ9Im1hc2swIiBtYXNrLXR5cGU9ImFscGhhIiBtYXNrVW5pdHM9InVzZXJTcGFjZU9uVXNlIiB4PSIwIiB5PSIwIiB3aWR0aD0iNjQiIGhlaWdodD0iNjQiPgo8Y2lyY2xlIGN4PSIzMiIgY3k9IjMyIiByPSIzMiIgZmlsbD0iI0M0QzRDNCIvPgo8L21hc2s+CjxnIG1hc2s9InVybCgjbWFzazApIj4KPGVsbGlwc2UgY3g9IjMyIiBjeT0iOTIiIHJ4PSI2NiIgcnk9IjUwIiBmaWxsPSIjRTg1RjhCIi8+CjwvZz4KPGRlZnM+CjxsaW5lYXJHcmFkaWVudCBpZD0icGFpbnQwX2xpbmVhciIgeDE9IjMyIiB5MT0iMCIgeDI9IjMyIiB5Mj0iNjQiIGdyYWRpZW50VW5pdHM9InVzZXJTcGFjZU9uVXNlIj4KPHN0b3Agb2Zmc2V0PSIwLjIwNzUxNyIgc3RvcC1jb2xvcj0iI0UyRTNGOSIvPgo8c3RvcCBvZmZzZXQ9IjAuODA2Nzc4IiBzdG9wLWNvbG9yPSIjQUFBQ0Y0Ii8+CjwvbGluZWFyR3JhZGllbnQ+CjwvZGVmcz4KPC9zdmc+Cg=="
				);
			case ITALY:
				return new Avatar(
						"PHN2ZyB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIHZpZXdCb3g9IjAgMCA2NCA2NCIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPGNpcmNsZSBjeD0iMzIiIGN5PSIzMiIgcj0iMzIiIGZpbGw9InVybCgjcGFpbnQwX2xpbmVhcikiLz4KPG1hc2sgaWQ9Im1hc2swIiBtYXNrLXR5cGU9ImFscGhhIiBtYXNrVW5pdHM9InVzZXJTcGFjZU9uVXNlIiB4PSIwIiB5PSIwIiB3aWR0aD0iNjQiIGhlaWdodD0iNjQiPgo8Y2lyY2xlIGN4PSIzMiIgY3k9IjMyIiByPSIzMiIgZmlsbD0iI0M0QzRDNCIvPgo8L21hc2s+CjxnIG1hc2s9InVybCgjbWFzazApIj4KPGVsbGlwc2UgY3g9IjMyIiBjeT0iOTIiIHJ4PSI2NiIgcnk9IjUwIiBmaWxsPSIjRTg1RjhCIi8+CjwvZz4KPHBhdGggZD0iTTMxLjUxMjEgMjguMjg1Nkw0My4wMzYzIDQ3LjU3MTRINTJWNDYuMTQyOEg1MC41NzEzVjM4Ljk5OTlINTJWMzcuNTcxNEg1MC41NzEzVjI5LjcxNDNINTJWMjguMjg1NkgzMS41MTIxWiIgZmlsbD0iIzJGMDVCMCIvPgo8cGF0aCBkPSJNNDMuNDI4NyA0MS4xNDI3QzQ0LjIxNzYgNDEuMTQyNyA0NC44NTcxIDQxLjc4MjIgNDQuODU3MSA0Mi41NzE0VjQ2LjE0MjdINDJWNDIuNTcxNEM0MiA0MS43ODIyIDQyLjYzOTUgNDEuMTQyNyA0My40Mjg3IDQxLjE0MjdaIiBmaWxsPSIjNUE0RUQwIi8+CjxwYXRoIGQ9Ik00OS4xNDI4IDQxLjE0MjdDNDkuOTMxNyA0MS4xNDI3IDUwLjU3MTIgNDEuNzgyMiA1MC41NzEyIDQyLjU3MTRWNDYuMTQyN0g0Ny43MTQxVjQyLjU3MTRDNDcuNzE0MSA0MS43ODIyIDQ4LjM1MzkgNDEuMTQyNyA0OS4xNDI4IDQxLjE0MjdaIiBmaWxsPSIjNUE0RUQwIi8+CjxwYXRoIGQ9Ik0zNy43MTQzIDMxLjg1NzFDMzguNTAzNSAzMS44NTcxIDM5LjE0MyAzMi40OTY4IDM5LjE0MyAzMy4yODU3VjM1LjQyODZIMzYuMjg1OVYzMy4yODU3QzM2LjI4NTkgMzIuNDk2OCAzNi45MjU0IDMxLjg1NzEgMzcuNzE0MyAzMS44NTcxWiIgZmlsbD0iIzVBNEVEMCIvPgo8cGF0aCBkPSJNNDMuNDI4NyAzMS44NTcxQzQ0LjIxNzYgMzEuODU3MSA0NC44NTcxIDMyLjQ5NjggNDQuODU3MSAzMy4yODU3VjM1LjQyODZINDJWMzMuMjg1N0M0MiAzMi40OTY4IDQyLjYzOTUgMzEuODU3MSA0My40Mjg3IDMxLjg1NzFaIiBmaWxsPSIjNUE0RUQwIi8+CjxwYXRoIGQ9Ik00OS4xNDI4IDMxLjg1NzFDNDkuOTMxNyAzMS44NTcxIDUwLjU3MTIgMzIuNDk2OCA1MC41NzEyIDMzLjI4NTdWMzUuNDI4Nkg0Ny43MTQxVjMzLjI4NTdDNDcuNzE0MSAzMi40OTY4IDQ4LjM1MzkgMzEuODU3MSA0OS4xNDI4IDMxLjg1NzFaIiBmaWxsPSIjNUE0RUQwIi8+CjxwYXRoIGQ9Ik0xMiAxOVYyMC40Mjg3SDEzLjQyODdWMjguMjg1OEgxMlYyOS43MTQ1SDEzLjQyODdWMzcuNTcxNkgxMlYzOUgxMy40Mjg3VjQ2LjE0MjlIMTJWNDcuNTcxNkg0My4wMzYzTDI1Ljk2MzcgMTlIMTJaIiBmaWxsPSIjNUE0RUQwIi8+CjxwYXRoIGQ9Ik0xNC44NTcgNDEuMTQyN0MxNS42NDU5IDQxLjE0MjcgMTYuMjg1NyA0MS43ODIyIDE2LjI4NTcgNDIuNTcxNFY0Ni4xNDI3SDEzLjQyODZWNDIuNTcxNEMxMy40Mjg2IDQxLjc4MjIgMTQuMDY4MSA0MS4xNDI3IDE0Ljg1NyA0MS4xNDI3WiIgZmlsbD0iIzFGMDQ3MSIvPgo8cGF0aCBkPSJNMjAuNTcxMSA0MS4xNDI3QzIxLjM2MDMgNDEuMTQyNyAyMS45OTk4IDQxLjc4MjIgMjEuOTk5OCA0Mi41NzE0VjQ2LjE0MjdIMTkuMTQyN1Y0Mi41NzE0QzE5LjE0MjcgNDEuNzgyMiAxOS43ODIyIDQxLjE0MjcgMjAuNTcxMSA0MS4xNDI3WiIgZmlsbD0iIzFGMDQ3MSIvPgo8cGF0aCBkPSJNMjYuMjg1NyA0MS4xNDI3QzI3LjA3NDcgNDEuMTQyNyAyNy43MTQyIDQxLjc4MjIgMjcuNzE0MiA0Mi41NzE0VjQ2LjE0MjdIMjQuODU3MVY0Mi41NzE0QzI0Ljg1NzEgNDEuNzgyMiAyNS40OTY2IDQxLjE0MjcgMjYuMjg1NyA0MS4xNDI3WiIgZmlsbD0iIzFGMDQ3MSIvPgo8cGF0aCBkPSJNMzIuMDAwMSA0MS4xNDI3QzMyLjc4OSA0MS4xNDI3IDMzLjQyODggNDEuNzgyMiAzMy40Mjg4IDQyLjU3MTRWNDYuMTQyN0gzMC41NzE0VjQyLjU3MTRDMzAuNTcxNCA0MS43ODIyIDMxLjIxMTIgNDEuMTQyNyAzMi4wMDAxIDQxLjE0MjdaIiBmaWxsPSIjMUYwNDcxIi8+CjxwYXRoIGQ9Ik0zNy43MTQzIDQxLjE0MjdDMzguNTAzNSA0MS4xNDI3IDM5LjE0MyA0MS43ODIyIDM5LjE0MyA0Mi41NzE0VjQ2LjE0MjdIMzYuMjg1OVY0Mi41NzE0QzM2LjI4NTkgNDEuNzgyMiAzNi45MjU0IDQxLjE0MjcgMzcuNzE0MyA0MS4xNDI3WiIgZmlsbD0iIzFGMDQ3MSIvPgo8cGF0aCBkPSJNMTQuODU3IDMxLjg1NzFDMTUuNjQ1OSAzMS44NTcxIDE2LjI4NTcgMzIuNDk2OCAxNi4yODU3IDMzLjI4NTdWMzUuNDI4NkgxMy40Mjg2VjMzLjI4NTdDMTMuNDI4NiAzMi40OTY4IDE0LjA2ODEgMzEuODU3MSAxNC44NTcgMzEuODU3MVoiIGZpbGw9IiMxRjA0NzEiLz4KPHBhdGggZD0iTTIwLjU3MTEgMzEuODU3MUMyMS4zNjAzIDMxLjg1NzEgMjEuOTk5OCAzMi40OTY4IDIxLjk5OTggMzMuMjg1N1YzNS40Mjg2SDE5LjE0MjdWMzMuMjg1N0MxOS4xNDI3IDMyLjQ5NjggMTkuNzgyMiAzMS44NTcxIDIwLjU3MTEgMzEuODU3MVoiIGZpbGw9IiMxRjA0NzEiLz4KPHBhdGggZD0iTTI2LjI4NTcgMzEuODU3MUMyNy4wNzQ3IDMxLjg1NzEgMjcuNzE0MiAzMi40OTY4IDI3LjcxNDIgMzMuMjg1N1YzNS40Mjg2SDI0Ljg1NzFWMzMuMjg1N0MyNC44NTcxIDMyLjQ5NjggMjUuNDk2NiAzMS44NTcxIDI2LjI4NTcgMzEuODU3MVoiIGZpbGw9IiMxRjA0NzEiLz4KPHBhdGggZD0iTTE0Ljg1NyAyMi41NzE1QzE1LjY0NTkgMjIuNTcxNSAxNi4yODU3IDIzLjIxMSAxNi4yODU3IDIzLjk5OTlWMjYuMTQyOEgxMy40Mjg2VjIzLjk5OTlDMTMuNDI4NiAyMy4yMTEgMTQuMDY4MSAyMi41NzE1IDE0Ljg1NyAyMi41NzE1WiIgZmlsbD0iIzFGMDQ3MSIvPgo8cGF0aCBkPSJNMjAuNTcxMSAyMi41NzE1QzIxLjM2MDMgMjIuNTcxNSAyMS45OTk4IDIzLjIxMSAyMS45OTk4IDIzLjk5OTlWMjYuMTQyOEgxOS4xNDI3VjIzLjk5OTlDMTkuMTQyNyAyMy4yMTEgMTkuNzgyMiAyMi41NzE1IDIwLjU3MTEgMjIuNTcxNVoiIGZpbGw9IiMxRjA0NzEiLz4KPHBhdGggZD0iTTI2LjI4NTcgMjIuNTcxNUMyNy4wNzQ3IDIyLjU3MTUgMjcuNzE0MiAyMy4yMTEgMjcuNzE0MiAyMy45OTk5VjI2LjE0MjhIMjQuODU3MVYyMy45OTk5QzI0Ljg1NzEgMjMuMjExIDI1LjQ5NjYgMjIuNTcxNSAyNi4yODU3IDIyLjU3MTVaIiBmaWxsPSIjMUYwNDcxIi8+CjxwYXRoIGQ9Ik0zMi4wMDAxIDMxLjg1NzFDMzIuNzg5IDMxLjg1NzEgMzMuNDI4OCAzMi40OTY4IDMzLjQyODggMzMuMjg1N1YzNS40Mjg2SDMwLjU3MTRWMzMuMjg1N0MzMC41NzE0IDMyLjQ5NjggMzEuMjExMiAzMS44NTcxIDMyLjAwMDEgMzEuODU3MVoiIGZpbGw9IiMxRjA0NzEiLz4KPHBhdGggZD0iTTI2LjgxNjcgMjAuNDI4MkgxMy40MjgyVjIxLjg1NjZIMjcuNjcwMkwyNi44MTY3IDIwLjQyODJaIiBmaWxsPSIjRTg1RjhCIi8+CjxwYXRoIGQ9Ik0zMi4zNjU1IDI5LjcxNDRIMTMuNDI4NlYzMS4xNDI4SDMzLjIxOTNMMzIuMzY1NSAyOS43MTQ0WiIgZmlsbD0iI0U4NUY4QiIvPgo8cGF0aCBkPSJNMzcuOTE1IDM5SDEzLjQyODZWNDAuNDI4N0gzOC43Njg1TDM3LjkxNSAzOVoiIGZpbGw9IiNFODVGOEIiLz4KPGRlZnM+CjxsaW5lYXJHcmFkaWVudCBpZD0icGFpbnQwX2xpbmVhciIgeDE9IjMyIiB5MT0iMCIgeDI9IjMyIiB5Mj0iNjQiIGdyYWRpZW50VW5pdHM9InVzZXJTcGFjZU9uVXNlIj4KPHN0b3Agb2Zmc2V0PSIwLjIwNzUxNyIgc3RvcC1jb2xvcj0iI0UyRTNGOSIvPgo8c3RvcCBvZmZzZXQ9IjAuODA2Nzc4IiBzdG9wLWNvbG9yPSIjQUFBQ0Y0Ii8+CjwvbGluZWFyR3JhZGllbnQ+CjwvZGVmcz4KPC9zdmc+Cg=="
				);
			case FRANCE:
				return new Avatar(
						"PHN2ZyB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIHZpZXdCb3g9IjAgMCA2NCA2NCIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPGNpcmNsZSBjeD0iMzIiIGN5PSIzMiIgcj0iMzIiIGZpbGw9InVybCgjcGFpbnQwX2xpbmVhcikiLz4KPG1hc2sgaWQ9Im1hc2swIiBtYXNrLXR5cGU9ImFscGhhIiBtYXNrVW5pdHM9InVzZXJTcGFjZU9uVXNlIiB4PSIwIiB5PSIwIiB3aWR0aD0iNjQiIGhlaWdodD0iNjQiPgo8Y2lyY2xlIGN4PSIzMiIgY3k9IjMyIiByPSIzMiIgZmlsbD0iI0M0QzRDNCIvPgo8L21hc2s+CjxnIG1hc2s9InVybCgjbWFzazApIj4KPGVsbGlwc2UgY3g9IjMyIiBjeT0iOTIiIHJ4PSI2NiIgcnk9IjUwIiBmaWxsPSIjRTg1RjhCIi8+CjxwYXRoIGQ9Ik0zOS4yNjI5IDM5LjEyMTdIMjQuODYyOEwxOC40NjI2IDUxLjEyMTdIMjQuODYyOEwyNS43NDI3IDQ4LjQ3NTNDMjYuOTA1NyA0NC45ODYgMzAuNjc2OCA0My4xMDAzIDM0LjE2NTggNDQuMjYyOUMzNi4xNTQ3IDQ0LjkyNTkgMzcuNzE1MSA0Ni40ODYzIDM4LjM3ODEgNDguNDc1M0wzOS4yNjI5IDUxLjEyMTdINDUuNjYyN0wzOS4yNjI5IDM5LjEyMTdaIiBmaWxsPSIjNUE0RUQwIi8+CjxwYXRoIGQ9Ik0zNS4yNjI5IDM5LjEyMTdIMzkuMjYyOUwzNi4wNjI5IDMwLjMyMThIMjguMDYyOUwyNC44NjI4IDM5LjEyMTdIMjguODYyOEwzMC40NjI3IDMzLjUyMTVIMzMuNjYyN0wzNS4yNjI5IDM5LjEyMTdaIiBmaWxsPSIjNUE0RUQwIi8+CjxwYXRoIGQ9Ik0yOC44NjI4IDMwLjMyMThMMzAuNDYyNyAxMS45MjE2SDMzLjY2MjdMMzUuMjYyOSAzMC4zMjE4SDI4Ljg2MjhaIiBmaWxsPSIjNUE0RUQwIi8+CjxwYXRoIGQ9Ik0xNi44NjI4IDUwLjMyMTdIMjcuMjYyOVY1MS45MjE1SDE2Ljg2MjhWNTAuMzIxN1oiIGZpbGw9IiM1QTRFRDAiLz4KPHBhdGggZD0iTTM2Ljg2MjggNTAuMzIxN0g0Ny4yNjI5VjUxLjkyMTVIMzYuODYyOFY1MC4zMjE3WiIgZmlsbD0iIzVBNEVEMCIvPgo8cGF0aCBkPSJNMzMuODcxNSAxNC4zMjE4TDMzLjY2MjYgMTEuOTIxNkgzMC40NjI1TDMwLjI1MzkgMTQuMzIxOEgzMy44NzE1WiIgZmlsbD0iI0NENDQ3MCIvPgo8cGF0aCBkPSJNMzEuMjYyNyAzLjkyMTYzSDMyLjg2MjZWOC43MjE1N0gzMS4yNjI3VjMuOTIxNjNaIiBmaWxsPSIjNUE0RUQwIi8+CjxwYXRoIGQ9Ik0zMC40NjI2IDguNzIxNjhIMzMuNjYyN1YxMS45MjE3SDMwLjQ2MjZWOC43MjE2OFoiIGZpbGw9IiM1QTRFRDAiLz4KPHBhdGggZD0iTTI4Ljg2MjggMTEuMTIxNkgzNS4yNjI5VjEyLjcyMTVIMjguODYyOFYxMS4xMjE2WiIgZmlsbD0iIzFGMDQ3MSIvPgo8cGF0aCBkPSJNMzIuODYzIDExLjEyMTZIMzUuMjYzMlYxMi43MjE1SDMyLjg2M1YxMS4xMjE2WiIgZmlsbD0iIzJGMDVCMCIvPgo8cGF0aCBkPSJNMzYuOTM1OSAzMi43MjE2TDM2LjA2MyAzMC4zMjE4SDI4LjA2M0wyNy4xOTAyIDMyLjcyMTZIMzYuOTM1OVoiIGZpbGw9IiNDRDQ0NzAiLz4KPHBhdGggZD0iTTI2LjQ2MjkgMjkuNTIxNkgzNy42NjNWMzEuMTIxOEgyNi40NjI5VjI5LjUyMTZaIiBmaWxsPSIjMUYwNDcxIi8+CjxwYXRoIGQ9Ik00MC41NDI5IDQxLjUyMTVMMzkuMjYyOSAzOS4xMjE3SDI0Ljg2MjhMMjMuNTgyOCA0MS41MjE1SDQwLjU0MjlaIiBmaWxsPSIjNUE0RUQwIi8+CjxwYXRoIGQ9Ik0yMy4yNjI5IDM4LjMyMThINDAuODYyOFYzOS45MjE2SDIzLjI2MjlWMzguMzIxOFoiIGZpbGw9IiMxRjA0NzEiLz4KPHBhdGggZD0iTTM1LjI2MjkgMjkuNTIxNkgzNy42NjI4VjMxLjEyMThIMzUuMjYyOVYyOS41MjE2WiIgZmlsbD0iIzJGMDVCMCIvPgo8cGF0aCBkPSJNMzguNDYyOSAzOC4zMjE4SDQwLjg2M1YzOS45MjE2SDM4LjQ2MjlWMzguMzIxOFoiIGZpbGw9IiMyRjA1QjAiLz4KPHBhdGggZD0iTTQ0Ljg2MjggNTAuMzIxN0g0Ny4yNjI5VjUxLjkyMTVINDQuODYyOFY1MC4zMjE3WiIgZmlsbD0iIzJGMDVCMCIvPgo8cGF0aCBkPSJNMjQuODYyOCA1MC4zMjE3SDI3LjI2MjlWNTEuOTIxNUgyNC44NjI4VjUwLjMyMTdaIiBmaWxsPSIjMkYwNUIwIi8+CjwvZz4KPGRlZnM+CjxsaW5lYXJHcmFkaWVudCBpZD0icGFpbnQwX2xpbmVhciIgeDE9IjMyIiB5MT0iMCIgeDI9IjMyIiB5Mj0iNjQiIGdyYWRpZW50VW5pdHM9InVzZXJTcGFjZU9uVXNlIj4KPHN0b3Agb2Zmc2V0PSIwLjIwNzUxNyIgc3RvcC1jb2xvcj0iI0UyRTNGOSIvPgo8c3RvcCBvZmZzZXQ9IjAuODA2Nzc4IiBzdG9wLWNvbG9yPSIjQUFBQ0Y0Ii8+CjwvbGluZWFyR3JhZGllbnQ+CjwvZGVmcz4KPC9zdmc+Cg=="
				);
			default:
				return Avatar.empty();
		}
	}
}

