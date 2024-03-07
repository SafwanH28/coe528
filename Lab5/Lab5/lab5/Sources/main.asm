*****************************************************************
;* This stationery serves as the framework for a                 *
;* user application (single file, absolute assembly application) *
;* For a more comprehensive program that                         *
;* demonstrates the more advanced functionality of this          *
;* processor, please see the demonstration applications          *
;* located in the examples subdirectory of the                   *
;* Freescale CodeWarrior for the HC12 Program directory          *
;*****************************************************************

; export symbols
            XDEF Entry, _Startup            ; export 'Entry' symbol
            ABSENTRY Entry        ; for absolute assembly: mark this as application entry point



; Include derivative-specific definitions
            INCLUDE 'derivative.inc'

ROMStart    EQU  $4000  ; absolute address to place my code/constant data

; variable/data section

            ORG RAMStart


; code section
            ORG   ROMStart


Entry:
_Startup:
           
         
;*******************************************************************
;* Lab 5: Robot Roaming Program (9S32C) *
;*******************************************************************
; equates section
;*******************************************************************

LCD_DAT ...
LCD_CNTR ...
LCD_E ...
LCD_RS ...
FWD_INT EQU 69 ; 3 second delay (at 23Hz)
REV_INT EQU 69 ; 3 second delay (at 23Hz)
FWD_TRN_INT EQU 46 ; 2 second delay (at 23Hz)
REV_TRN_INT EQU 46 ; 2 second delay (at 23Hz)
14
START EQU 0
FWD EQU 1
REV EQU 2
ALL_STP EQU 3
FWD_TRN EQU 4
REV_TRN EQU 5
; variable section
*******************************************************************
ORG $3850 ; Where our TOF counter register lives
TOF_COUNTER dc.b 0 ; The timer, incremented at 23Hz
CRNT_STATE dc.b 3 ; Current state register
T_FWD ds.b 1 ; FWD time
T_REV ds.b 1 ; REV time
T_FWD_TRN ds.b 1 ; FWD_TURN time
T_REV_TRN ds.b 1 ; REV_TURN time
TEN_THOUS ds.b 1 ; 10,000 digit
THOUSANDS ds.b 1 ; 1,000 digit
HUNDREDS ds.b 1 ; 100 digit
TENS ds.b 1 ; 10 digit
UNITS ds.b 1 ; 1 digit
NO_BLANK ds.b 1 ; Used in ’leading zero’ blanking by BCD2ASC
; code section
*******************************************************************
ORG $4000 ; Where the code starts --------------------
Entry: ; |
_Startup: ; |
CLI ; Enable interrupts |
LDS #$4000 ; Initialize the stack pointer
; I
BSET DDRA,%00000011 ; STAR_DIR, PORT_DIR N
BSET DDRT,%00110000 ; STAR_SPEED, PORT_SPEED I
; T
JSR initAD ; Initialize ATD converter I
; A
JSR initLCD ; Initialize the LCD L
JSR clrLCD ; Clear LCD & home cursor I
; Z
LDX #msg1 ; Display msg1 A
JSR putsLCD ; " T
; I
LDAA #$C0 ; Move LCD cursor to the 2nd row O
JSR cmd2LCD ; N
LDX #msg2 ; Display msg2 |
JSR putsLCD ; " |
; |
JSR ENABLE_TOF ; Jump to TOF initialization ---------------
MAIN JSR UPDT_DISPL ; ----------------------------------------- M
LDAA CRNT_STATE ; A
JSR DISPATCHER ; I
BRA MAIN ; ----------------------------------------- N
; data section
*******************************************************************
msg1 dc.b "Battery volt ",0
msg2 dc.b "State ",0
tab dc.b "START ",0
dc.b "FWD ",0
dc.b "REV ",0
dc.b "ALL_STP",0
dc.b "FWD_TRN",0
dc.b "REV_TRN",0
15
; subroutine section
*******************************************************************
DISPATCHER CMPA #START ; If it’s the START state -----------------
BNE NOT_START ; |
JSR START_ST ; then call START_ST routine D
BRA DISP_EXIT ; and exit I
; S
NOT_START ... ; P
... ; A
; T
NOT_FWD_TRN CMPA #REV_TRN ; Else if it’s the REV_TRN state C
BNE NOT_REV_TRN ; H
JSR REV_TRN_ST ; then call REV_TRN_ST routine E
BRA DISP_EXIT ; and exit R
; |
NOT_REV_TRN SWI ; Else the CRNT_ST is not defined, so stop |
DISP_EXIT RTS ; Exit from the state dispatcher ----------
*******************************************************************
START_ST ...
...
NO_FWD NOP ; Else
START_EXIT RTS ; return to the MAIN routine
*******************************************************************
FWD_ST ...
...
NO_FWD_TRN NOP ; Else
FWD_EXIT RTS ; return to the MAIN routine
*******************************************************************
REV_ST LDAA TOF_COUNTER ; If Tc>Trev then
CMPA T_REV ; the robot should make a FWD turn
BNE NO_REV_TRN ; so
JSR INIT_REV_TRN ; initialize the REV_TRN state
MOVB #REV_TRN,CRNT_STATE ; set state to REV_TRN
BRA REV_EXIT ; and return
NO_REV_TRN NOP ; Else
REV_EXIT RTS ; return to the MAIN routine
*******************************************************************
ALL_STP_ST BRSET PORTAD0,$04,NO_START ; If FWD_BUMP
BCLR PTT,%00110000 ; initialize the START state (both motors off)
MOVB #START,CRNT_STATE ; set the state to START
BRA ALL_STP_EXIT ; and return
NO_START NOP ; Else
ALL_STP_EXIT RTS ; return to the MAIN routine
*******************************************************************
FWD_TRN_ST LDAA TOF_COUNTER ; If Tc>Tfwdturn then
CMPA T_FWD_TRN ; the robot should go FWD
BNE NO_FWD_FT ; so
JSR INIT_FWD ; initialize the FWD state
MOVB #FWD,CRNT_STATE ; set state to FWD
BRA FWD_TRN_EXIT ; and return
NO_FWD_FT NOP ; Else
FWD_TRN_EXIT RTS ; return to the MAIN routine
*******************************************************************
REV_TRN_ST LDAA TOF_COUNTER ; If Tc>Trevturn then
CMPA T_REV_TRN ; the robot should go FWD
16
BNE NO_FWD_RT ; so
JSR INIT_FWD ; initialize the FWD state
MOVB #FWD,CRNT_STATE ; set state to FWD
BRA REV_TRN_EXIT ; and return
NO_FWD_RT NOP ; Else
REV_TRN_EXIT RTS ; return to the MAIN routine
*******************************************************************
INIT_FWD BCLR PORTA,%00000011 ; Set FWD direction for both motors
BSET PTT,%00110000 ; Turn on the drive motors
LDAA TOF_COUNTER ; Mark the fwd time Tfwd
ADDA #FWD_INT
STAA T_FWD
RTS
*******************************************************************
INIT_REV BSET PORTA,%00000011 ; Set REV direction for both motors
BSET PTT,%00110000 ; Turn on the drive motors
LDAA TOF_COUNTER ; Mark the fwd time Tfwd
ADDA #REV_INT
STAA T_REV
RTS
*******************************************************************
INIT_ALL_STP BCLR PTT,%00110000 ; Turn off the drive motors
RTS
*******************************************************************
INIT_FWD_TRN BSET PORTA,%00000010 ; Set REV dir. for STARBOARD (right) motor
LDAA TOF_COUNTER ; Mark the fwd_turn time Tfwdturn
ADDA #FWD_TRN_INT
STAA T_FWD_TRN
RTS
*******************************************************************
INIT_REV_TRN BCLR PORTA,%00000010 ; Set FWD dir. for STARBOARD (right) motor
LDAA TOF_COUNTER ; Mark the fwd time Tfwd
ADDA #REV_TRN_INT
STAA T_REV_TRN
RTS
; utility subroutines
*******************************************************************
initLCD ...
*******************************************************************
clrLCD ...
*******************************************************************
del_50us PSHX ; (2 E-clk) Protect the X register
eloop LDX #300 ; (2 E-clk) Initialize the inner loop counter
iloop NOP ; (1 E-clk) No operation
DBNE X,iloop ; (3 E-clk) If the inner cntr not 0, loop again
DBNE Y,eloop ; (3 E-clk) If the outer cntr not 0, loop again
PULX ; (3 E-clk) Restore the X register
RTS ; (5 E-clk) Else return
*******************************************************************
cmd2LCD: ...
*******************************************************************
putsLCD ...
*******************************************************************
putcLCD ...
17
*******************************************************************
dataMov ...
*******************************************************************
initAD ...
*******************************************************************
int2BCD ...
*******************************************************************
BCD2ASC ...
*******************************************************************
ENABLE_TOF ...
*******************************************************************
TOF_ISR ...
*******************************************************************
* Update Display (Battery Voltage + Current State) *
*******************************************************************
UPDT_DISPL MOVB #$90,ATDCTL5 ; R-just., uns., sing. conv., mult., ch=0, start
BRCLR ATDSTAT0,$80,* ; Wait until the conver. seq. is complete
LDAA ATDDR0L ; Load the ch0 result - battery volt - into A
... ; Display the battery voltage
;-------------------------
LDAA #$C6 ; Move LCD cursor to the 2nd row, end of msg2
JSR cmd2LCD ;
LDAB CRNT_STATE ; Display current state
LSLB ; "
LSLB ; "
LSLB ; "
LDX #tab ; "
ABX ; "
JSR putsLCD ; "
RTS
*******************************************************************
* Interrupt Vectors *
*******************************************************************
ORG $FFFE
DC.W Entry ; Reset Vector
ORG $FFDE
DC.W TOF_ISR ; Timer Overflow Interrupt Vector          
;**************************************************************
;*                 Interrupt Vectors                          *
;**************************************************************
            ORG   $FFFE
            DC.W  Entry           ; Reset Vector
